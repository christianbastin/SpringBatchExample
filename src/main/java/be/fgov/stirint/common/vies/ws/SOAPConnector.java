package be.fgov.stirint.common.vies.ws;

import be.fgov.minfin.stirint.common.api.vies.ws.CheckVat;
import be.fgov.minfin.stirint.common.api.vies.ws.CheckVatResponse;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.FaultMessageResolver;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.io.IOException;

public class SOAPConnector extends WebServiceGatewaySupport implements FaultMessageResolver {



    public CheckVatResponse callVies(String url, CheckVat request){
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setFaultMessageResolver(this);

        return (CheckVatResponse) webServiceTemplate.marshalSendAndReceive(url, request);
    }

    @Override
    public void resolveFault(WebServiceMessage webServiceMessage) throws IOException {
        webServiceMessage.getPayloadResult();
    }
}