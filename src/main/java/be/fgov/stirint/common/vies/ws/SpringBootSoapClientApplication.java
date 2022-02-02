package be.fgov.stirint.common.vies.ws;

import be.fgov.minfin.stirint.common.api.vies.ws.CheckVat;
import be.fgov.minfin.stirint.common.api.vies.ws.CheckVatResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.jaxws.JaxWsSoapFaultException;

@SpringBootApplication
public class SpringBootSoapClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapClientApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {
            CheckVat request = new CheckVat();
            request.setCountryCode("");
            request.setVatNumber("");
            try {
                //CheckVatResponse response = soapConnector.callVies("http://ec.europa.eu/taxation_customs/vies/services/checkVatService", request);
                CheckVatResponse response = soapConnector.callVies("http://ec.europa.eu/taxation_customs/vies/services/checkVatTestService", request);
                System.out.println("Got Response As below ========= : ");
                System.out.println("Name : "+response.getName());
                System.out.println("Standard : "+response.getAddress());
                System.out.println("Address : "+response.isValid());
            } catch (Exception e){
                e.printStackTrace();
            }
        };
    }
}