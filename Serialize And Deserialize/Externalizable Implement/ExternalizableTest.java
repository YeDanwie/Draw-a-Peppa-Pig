import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
 
/**
 * @description Externalizable接口的使用
 */
public class ExternalizableTest implements Externalizable {
 
    private transient String content = "Wow...";
    private static int num = 100;
    private String name;
    private int age;
 
    public void set(String content, int num, String name, int age) {
    	this.content = content;
    	this.num = num;
    	this.name = name;
    	this.age = age;
    }
    
    @Override
    public String toString() {
    	String str = new String();
    	str = " content = " + content
    		+ "\n num = " + num
    		+ "\n name = " + name
    		+ "\n age = " + age;
    	
    	return str;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(content);
		out.writeInt(num);
		out.writeObject(name);
	}



	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		content = (String) in.readObject();
		num = (int) in.readInt();
		name = (String) in.readObject();
	}
    
    public static void main(String[] args) throws Exception {
        
        ExternalizableTest et = new ExternalizableTest();
        et.set("Emm...", 200, "Bob", 20);
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File("data.ser")));
        out.writeObject(et);
 
        ObjectInput in = new ObjectInputStream(new FileInputStream(new File("data.ser")));
        et = (ExternalizableTest) in.readObject();
        System.out.println(et);
 
        out.close();
        in.close();
    }


}
