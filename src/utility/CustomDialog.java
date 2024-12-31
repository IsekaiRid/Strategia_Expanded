package utility;

import arc.*;
import arc.scene.style.*;
import arc.scene.ui.*;
import arc.util.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.ui.*;
import mindustry.ui.dialogs.*;

public class CustomDialog extends Dialog {

    public CustomDialog(String titleText) {
        super(titleText); // Mengatur judul dialog
        initialize();
    }

    private void initialize() {
        // Mengatur properti dasar
        this.setMovable(true); // Membuat dialog bisa digeser
        this.setModal(true);   // Membuat dialog sebagai modal

        // Membuat font dari default font yang ada di Mindustry
        BitmapFont font = Core.font;  // Menggunakan font default dari Core

        // Membuat LabelStyle dengan font yang sudah ditentukan
        LabelStyle labelStyle = new LabelStyle();
        labelStyle.font = font; // Set font untuk label

        // Menambahkan konten ke dialog
        cont.add(new Label("This is a custom dialog!", labelStyle)).row(); // Tambahkan label dengan gaya
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
        return this;
    }
}
