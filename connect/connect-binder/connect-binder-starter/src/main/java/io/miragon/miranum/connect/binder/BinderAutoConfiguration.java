package io.miragon.miranum.connect.binder;


import io.miragon.miranum.connect.binder.adapter.in.ContextInitalizer;
import io.miragon.miranum.connect.binder.adapter.in.UseCaseInfoMapper;
import io.miragon.miranum.connect.binder.application.port.in.ExecuteMethodUseCase;
import io.miragon.miranum.connect.binder.application.port.in.InitializeUseCase;
import io.miragon.miranum.connect.binder.application.port.out.BindUseCasePort;
import io.miragon.miranum.connect.binder.application.port.out.ExecuteUseCaseInterceptor;
import io.miragon.miranum.connect.binder.application.service.ExecuteMethodService;
import io.miragon.miranum.connect.binder.application.service.InitalizeUseCasesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import(ContextInitalizer.class)
public class BinderAutoConfiguration {

    @Bean
    public UseCaseInfoMapper useCaseInfoMapper() {
        return new UseCaseInfoMapper();
    }

    @Bean
    public ExecuteMethodUseCase executeMethodUseCase(final List<ExecuteUseCaseInterceptor> interceptors) {
        return new ExecuteMethodService(interceptors);
    }

    @Bean
    public InitializeUseCase initalizeUseCasesService(final BindUseCasePort bindUseCasePort) throws Exception {
        return new InitalizeUseCasesService(bindUseCasePort);
    }
}
