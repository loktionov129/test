import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class HelloWorld{
	private static HelloWorld instance;
    public static void main(String[] args){
        instantiateHelloWorldMainClassAndRun();
    }
    
    public static void instantiateHelloWorldMainClassAndRun(){
    	instance = new HelloWorld();
    	
    }
    
    public HelloWorld(){
    	HelloWorldFactory factory = HelloWorldFactory.getInstance();
    	IHelloWorld helloWorld = factory.createHelloWorld();
    	IHelloWorldString helloWorldString = helloWorld.getHelloWorld();
    	IPrintStrategy printStrategy = helloWorld.getPrintStrategy();
    	IStatusCode code = helloWorld.print(printStrategy, helloWorldString);
    	if(code.getStatusCode() != 0){
    		throw new RuntimeException("Failed to print: " + code.getStatusCode());
    	}
    }
}

class StringFactory{
	private static StringFactory instance = new StringFactory();
	public static StringFactory getInstance(){
		return instance;
	}
	public HelloWorldString createHelloWorldString(String str){
		HelloWorldString s = new HelloWorldString();
		s.s = str;
		return s;
	}
}

class PrintStrategyFactory{
	private static PrintStrategyFactory instance = new PrintStrategyFactory();
	public static PrintStrategyFactory getInstance(){
		return instance;
	}
	public IPrintStrategy createIPrintStrategy(){
		IPrintStrategy printStrategy = new PrintStrategyImplementation();
		IStatusCode code = printStrategy.setupPrinting();
		if(code.getStatusCode() != 0){
			throw new RuntimeException("Failed to create IPrintStrategy: " + code.getStatusCode());
		}
		return printStrategy;
	}
}

class PrintStrategyImplementation implements IPrintStrategy{
	private OutputStream print;
	public IStatusCode setupPrinting() {
		try{
			FileDescriptor descriptor = FileDescriptor.out;
			print = new FileOutputStream(descriptor);
			return new StatusCodeImplementation(0);
		}
		catch(Exception e){
			return new StatusCodeImplementation(-1);
		}
	}
	public IStatusCode print(IHelloWorldString string) {
		try{
			print.write(string.getHelloWorldString().getHelloWorldString().concat("\n").getBytes("UTF-8"));
			return new StatusCodeImplementation(0);
		}
		catch(Exception e){
			return new StatusCodeImplementation(-1);
		}
	}
	
}

class StatusCodeImplementation implements IStatusCode{
	private int code;
	public StatusCodeImplementation(int code){
		this.code = code;
	}
	public int getStatusCode() {
		return code;
	}
}

class HelloWorldString{
	String s;
	public String getHelloWorldString(){
		return s;
	}
}

class HelloWorldStringImplementation implements IHelloWorldString{
	public HelloWorldString getHelloWorldString(){
		StringFactory factory = StringFactory.getInstance();
		HelloWorldString s = factory.createHelloWorldString("Hello, World!");
		return s;
	}
}

class HelloWorldFactory{
	private static HelloWorldFactory instance = new HelloWorldFactory();
	public static HelloWorldFactory getInstance(){
		return instance;
	}
	public IHelloWorld createHelloWorld(){
		IHelloWorld helloWorld = new HelloWorldImplementation();
		return helloWorld;
	}
}

class HelloWorldImplementation implements IHelloWorld{
	public IHelloWorldString getHelloWorld() {
		IHelloWorldString string = new HelloWorldStringImplementation();
		return string;
	}
	public IPrintStrategy getPrintStrategy() {
		PrintStrategyFactory factory = PrintStrategyFactory.getInstance();
		return factory.createIPrintStrategy();
	}
	public IStatusCode print(IPrintStrategy strategy, IHelloWorldString toPrint) {
		IStatusCode code = strategy.print(toPrint);
		return code;
	}
}

interface IHelloWorldString{
	public HelloWorldString getHelloWorldString();
}
interface IHelloWorld{
    public IHelloWorldString getHelloWorld();
    public IPrintStrategy getPrintStrategy();
    public IStatusCode print(IPrintStrategy strategy, IHelloWorldString toPrint);
}
interface IStatusCode{
	public int getStatusCode();
}
interface IPrintStrategy{
	public IStatusCode setupPrinting();
	public IStatusCode print(IHelloWorldString string);
}
