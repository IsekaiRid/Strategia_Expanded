package utility;

import arc.scene.ui.Dialog;
import arc.scene.ui.layout.Table;
import arc.scene.ui.Label;
import arc.scene.ui.TextButton;

public class CustomDialog extends Dialog {

    public CustomDialog(String titleText) {
        super(titleText); // Mengatur judul dialog
        initialize(titleText);
    }

    private void initialize(String titleText) {
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
}
