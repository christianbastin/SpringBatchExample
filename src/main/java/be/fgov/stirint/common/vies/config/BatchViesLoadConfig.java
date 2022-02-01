package be.fgov.stirint.common.vies.config;

import be.fgov.stirint.common.vies.batch.ViesProcessor;
import be.fgov.stirint.common.vies.batch.ViesWriter;
import be.fgov.stirint.common.vies.model.Vies;
import be.fgov.stirint.common.vies.model.ViesFieldSetMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableBatchProcessing
@EnableScheduling
public class BatchViesLoadConfig {

    private static final String FILE_NAME = "vies.csv";
    private static final String JOB_NAME = "listViesJob";
    private static final String STEP_NAME = "viesProcessingStep";
    private static final String READER_NAME = "viesItemReader";

    @Value("${vies.header.names}")
    private String names;

    @Value("${line.delimiter}")
    private String delimiter;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step viesStep() {
        return stepBuilderFactory.get(STEP_NAME)
                .<Vies, Vies>chunk(5)
                .reader(viesItemReader())
                .processor(viesItemProcessor())
                .writer(viesItemWriter())
                .build();
    }

    @Bean(name="listViesJob")
    public Job listViesJob(Step viesStep) {
        return jobBuilderFactory.get(JOB_NAME)
                .start(viesStep)
                .build();
    }
    
    @Bean
    public ItemReader<Vies> viesItemReader() {
        FlatFileItemReader<Vies> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource(FILE_NAME));
        reader.setName(READER_NAME);
        reader.setLinesToSkip(1);
        reader.setLineMapper(viesLineMapper());
        return reader;

    }

    @Bean
    public LineMapper<Vies> viesLineMapper() {

        final DefaultLineMapper<Vies> defaultLineMapper = new DefaultLineMapper<>();
        final DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(delimiter);
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(names.split(delimiter));

        final ViesFieldSetMapper fieldSetMapper = new ViesFieldSetMapper();
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

    @Bean
    public ItemProcessor<Vies, Vies> viesItemProcessor() {
        return new ViesProcessor();
    }

    @Bean
    public ItemWriter<Vies> viesItemWriter() {
        return new ViesWriter();
    }
}
