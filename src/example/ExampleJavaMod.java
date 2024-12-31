package example;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class ExampleJavaMod extends Mod {

    public ExampleJavaMod() {
        Log.info("Loaded ExampleJavaMod constructor.");

        // Mendengarkan event saat game dimuat
        Events.on(ClientLoadEvent.class, e -> {
            // Menampilkan dialog setelah startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Komando");
                dialog.cont.add("Halo, saya Komando.").row();
                dialog.cont.add("Garis pertahanan pertama bumi.").row();
                dialog.cont.add("Salam kenal, mari kita bertahan dari ambang kehancuran.").row();
                // Menampilkan gambar (ganti 'example-java-mod-icon' dengan sprite Anda)
                dialog.cont.image(Core.atlas.find("example-java-mod-icon")).pad(20f).row();
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
