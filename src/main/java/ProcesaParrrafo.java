import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.StringTokenizer;

public class ProcesaParrrafo  extends HTMLEditorKit.ParserCallback {

    private int contador ;
    private boolean inParagraph;

    public ProcesaParrrafo() {
        contador = 0;
        inParagraph = false;
    }

    @Override
    public void handleText(char[] data, int pos) {

        if( inParagraph ) {
            String texto = new String(data);
            StringTokenizer st = new StringTokenizer(texto);
            System.out.println("El parrafo tiene " + st.countTokens()+" palabras");
        }
    }


    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = false;
            contador++;
        }
        if( t == HTML.Tag.BODY ) {
            System.out.printf("Total de parrafos en documento: %d%n", contador);
        }
    }

}
