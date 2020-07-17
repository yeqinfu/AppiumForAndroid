package testapplication;

import testflow.TestFlow;

import java.util.List;

public interface TestApplication {
     List<TestFlow> getTestFlow();

     void startAllTestFlow();
}
