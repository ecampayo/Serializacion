import java.io.IOException;
import java.io.ObjectOutputStream;

public class MiObjectOutputStream extends ObjectOutputStream {
    //Hereda las propiedades de ObjectOutputStream
    //Sobreescribe la cabecera
    protected void writeStreamHeader() throws IOException{
        //No tocamos nada
    }
    public MiObjectOutputStream() throws IOException{
        super();
    }
    public MiObjectOutputStream(ObjectOutputStream out) throws IOException{
        super(out);
    }
}
