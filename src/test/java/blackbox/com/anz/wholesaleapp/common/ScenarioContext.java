package blackbox.com.anz.wholesaleapp.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Scope("cucumber-glue")
public class ScenarioContext {
  private final Map<ContextPropertyKey, Object>
}
