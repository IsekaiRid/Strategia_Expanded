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
import mindustry.ui.Icon;
import mindustry.graphics.Pal;
import arc.graphics.Color;

public class ExampleJavaMod extends Mod {

    private static Links.LinkEntry[] links;
    private static final String MOD_GITHUB_URL = "https://github.com/Yuria-Shikibe/NewHorizonMod";

    public ExampleJavaMod() {
        Log.info("Loaded ExampleJavaMod constructor.");

        // Mendengarkan event saat game dimuat
        Events.on(ClientLoadEvent.class, e -> {
            // Menampilkan dialog setelah startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("anime");
                dialog.cont.add("Halo, saya Komando.").row();
                dialog.cont.add("Garis pertahanan pertama bumi.").row();
                dialog.cont.add("Salam kenal, mari kita bertahan dari ambang kehancuran.").row();

                // Menampilkan gambar (gunakan sprite yang ada atau sesuaikan)
                dialog.cont.image(Core.atlas.find("anime")).pad(20f).row();
                dialog.cont.button("Oke", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    // Menampilkan dialog tentang mod
    private static void showAbout() {
        if (links == null) {
            links = new Links.LinkEntry[]{
                new Links.LinkEntry("mod.ccs", "https://github.com/Yuria-Shikibe/NewHorizonMod/wiki/Cutscene-Script-Custom-Guide", Icon.settings, Pal.heal),
                new Links.LinkEntry("mod.discord", "https://discord.gg/yNmbMcuwyW", Icon.discord, Color.valueOf("7289da")),
                new Links.LinkEntry("mod.github", MOD_GITHUB_URL, Icon.github, Color.valueOf("24292e")),
                new Links.LinkEntry("mod.guide", "https://github.com/Yuria-Shikibe/NewHorizonMod#mod-guide", Icon.bookOpen, Pal.accent),
                new Links.LinkEntry("yuria.plugin", "https://github.com/Yuria-Shikibe/RangeImager", Icon.export, Color.valueOf("ff4c4c"))
            };
        }

        BaseDialog dialog = new BaseDialog("@links");
        dialog.cont.pane(table -> {
            for (Links.LinkEntry entry : links) {
                TableFunc.link(table, entry);
            }
        }).grow().row();
        dialog.cont.button("@back", Icon.left, Styles.cleart, dialog::hide).size(150f, 50f);
        dialog.addCloseListener();
        dialog.show();
    }

    @Override
    public void loadContent() {
        Log.info("Loading Strategia Expanded content.");
    }
}
