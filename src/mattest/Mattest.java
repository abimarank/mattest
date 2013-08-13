package mattest;

import matlabcontrol.*;

public class Mattest {

    public static void main(String[] args)
            throws MatlabConnectionException, MatlabInvocationException {
        // create proxy
        MatlabProxyFactoryOptions options =
                new MatlabProxyFactoryOptions.Builder()
                .setUsePreviouslyControlledSession(true)
                .build();
        MatlabProxyFactory factory = new MatlabProxyFactory(options);
        MatlabProxy proxy = factory.getProxy();       
        
        proxy.eval(new String("x=5;"));
        proxy.eval(new String("sqrt(x)"));
        // call builtin function
        proxy.eval("disp('hello world')");

        // call user-defined function (must be on the path)
        proxy.eval("addpath('F:\\BlueBirds\\Matlab')");
        proxy.feval("myfunc");
        proxy.feval("img");
//        proxy.eval("rmpath('F:\\BlueBirds\\Matlab\\test.txt')");

        // close connection
        proxy.disconnect();
    }
}
