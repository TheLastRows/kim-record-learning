package com.demo.druid;

import io.undertow.server.DefaultByteBufferPool;
import io.undertow.websockets.jsr.WebSocketDeploymentInfo;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.UndertowServletWebServerFactoryCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.stereotype.Component;

import static io.undertow.websockets.jsr.WebSocketDeploymentInfo.ATTRIBUTE_NAME;

@Component
public class UndertowPoolCustomizer extends UndertowServletWebServerFactoryCustomizer {
    public UndertowPoolCustomizer(ServerProperties serverProperties) {
        super(serverProperties);
    }

    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        super.customize(factory);
        WebSocketDeploymentInfo webSocketDeploymentInfo = new WebSocketDeploymentInfo();
        webSocketDeploymentInfo.setBuffers(new DefaultByteBufferPool(false, 1024));
        factory.addDeploymentInfoCustomizers(deploymentInfo -> deploymentInfo.addServletContextAttribute(ATTRIBUTE_NAME, webSocketDeploymentInfo));
    }
}
