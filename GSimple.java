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
        showAll();
    }

    public void initUI() {
        HBox hbox = new HBox(true, 2);

        //vbox.packStart(new Label("Try"));

        Button ok = new Button("OK");
        ok.connect(new Button.Clicked() {
            public void onClicked(Button source) {
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
