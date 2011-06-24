import org.gnome.gdk.Event;
import org.gnome.gtk.Gtk;
import org.gnome.gtk.HBox;
import org.gnome.gtk.Button;
import org.gnome.gtk.Widget;
import org.gnome.gtk.Window;
import org.gnome.gtk.WindowPosition;
import org.gnome.gtk.MessageDialog;
import org.gnome.gtk.MessageType;
import org.gnome.gtk.ButtonsType;

public class GSimple extends Window  {

    public GSimple() {

        setTitle("Simple");

        initUI();

        connect(new Window.DeleteEvent() {
            public boolean onDeleteEvent(Widget source, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });

        setDefaultSize(250, 150);
        setPosition(WindowPosition.CENTER);
//Ώστε να εμφανίσει το window και το περιεχόμενο του.
//Αν θέλαμε να εμφανίσει μόνο το window θα γράφαμε show();.
        showAll();
    }

    public void initUI() {
//O container ωστε να βάλουμε τα κουμπιά.
//Η πρώτη παράμετρος θέτει αν θέλουμε τα components που περιέχει να έχουν το ίδιο περιθώριο.
//Η δεύτερη θέτει το περιθώριο.
        HBox hbox = new HBox(true, 2);

        Button ok = new Button("OK");
        ok.connect(new Button.Clicked() {
            public void onClicked(Button source) {
//Οι παράμετροι είναι οι εξής (με τη σειρά)
//Το γονικό παράθυρο δλδ να εμφανίζεται όταν διαλέγουμε το γονέα και να τον επικαλύπτει.
//Αν είναι modal δλδ να μπλοκάρει άλλα παράθυρα
//Ο τύπος του παράθυρου πχ ενημερωτικό,προειδοποιητικό κτλ 
//Ο τύπος του κουμπιού ,συνήθως σχετίζεται με τη συμπεριφορά του κουμπιού
//Το κείμενο που θέλουμε να εμφανίσει.
		MessageDialog md = new MessageDialog(null, true,
                        MessageType.INFO,
                        ButtonsType.CLOSE, "You clicked Ok!");
                md.setPosition(WindowPosition.CENTER);
                md.run();
                md.hide();
            }
        });

        Button close = new Button("Close");
        close.connect(new Button.Clicked() {
            public void onClicked(Button source) {
		Gtk.mainQuit();
            }
        });

        hbox.add(ok);
        hbox.add(close);

        add(hbox);
    }

    public static void main(String[] args) {
        Gtk.init(args);
        new GSimple();
        Gtk.main();
    }
}
