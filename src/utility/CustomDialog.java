package utility;

import arc.scene.ui.Dialog;
import arc.scene.ui.Label;
import arc.scene.ui.TextButton;
import arc.scene.ui.layout.Table;
import arc.scene.style.TextureRegionDrawable;
import arc.graphics.g2d.TextureRegion;
import arc.util.Time;

public class CustomDialog extends Dialog {

    public CustomDialog(String titleText) {
        super(titleText); // Mengatur judul dialog
        initialize();
    }

    private void initialize() {
        // Mengatur properti dasar
        this.setMovable(true); // Membuat dialog bisa digeser
        this.setModal(true);   // Membuat dialog sebagai modal

        // Menambahkan konten ke dialog
        cont.add(new Label("This is a custom dialog!")).row(); // Tambahkan label
        cont.add(new TextButton("Click Me", new TextButton.TextButtonStyle())).row(); // Tambahkan tombol

        // Menambahkan tombol ke bagian bawah dialog
        buttons.add(new TextButton("OK", new TextButton.TextButtonStyle()))
               .pad(10)
               .size(100, 50)
               .left();

        buttons.add(new TextButton("Cancel", new TextButton.TextButtonStyle()))
               .pad(10)
               .size(100, 50)
               .right();
    }

    @Override
    public Dialog show() {
        super.show();
        // Set the dialog to appear for a specified time (example: 5 seconds)
        Time.runTask(5f, this::hide);
        return this;
    }
}
