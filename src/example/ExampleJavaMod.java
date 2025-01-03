package example;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import mindustry.ui.Styles;

public class ExampleJavaMod extends Mod {

    public ExampleJavaMod() {
        Log.info("Loaded ExampleJavaMod constructor.");

        // Mendengarkan event saat game dimuat
        Events.on(ClientLoadEvent.class, e -> {
            // Menampilkan dialog setelah startup
            Time.runTask(10f, () -> {
                // Menampilkan dialog pertama menggunakan BaseDialog
                BaseDialog dialog = new BaseDialog("anime");
                dialog.cont.add("Halo, saya Komando.").row();
                dialog.cont.add("Garis pertahanan pertama bumi.").row();
                dialog.cont.add("Salam kenal, mari kita bertahan dari ambang kehancuran.").row();

                // Menampilkan gambar (gunakan sprite yang ada atau sesuaikan)
                dialog.cont.image(Core.atlas.find("example-java-mod-anime")).pad(20f).row();
                dialog.cont.button("Repo saya", () -> Core.app.openURI("https://github.com/IsekaiRid/Strategia_Expanded")).size(200f, 50f).row();

                // Menambahkan tombol untuk menutup dialog
                dialog.cont.button("Oke", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
    public void loadContent() {
        Log.info("Loading Strategia Expanded content.");
    }
}
