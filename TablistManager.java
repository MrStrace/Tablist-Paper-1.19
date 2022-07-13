package dev.strace.tablist;

import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class TablistManager {
    private Main instance;
    private List<TextComponent> headers = new ArrayList<>();
    private List<TextComponent> footers = new ArrayList<>();
    public final String nl = "\n"; // NEW LINE

    //Settings
    private int speed = 60;
    private int delay = 0;

    public TablistManager(Main instance) {
        this.instance = instance;
    }

    public void showTab() {

        if (headers.isEmpty() && footers.isEmpty()) return;

        Bukkit.getScheduler().scheduleSyncRepeatingTask(instance, new Runnable() {
            int count = 0;
            int count2 = 0;

            @Override
            public void run() {
                if (count >= headers.size())
                    count = 0;
                if (count2 >= footers.size())
                    count2 = 0;
                for (Player p : Bukkit.getOnlinePlayers()) {

                    p.sendPlayerListHeader(headers.get(count));
                    p.sendPlayerListFooter(footers.get(count2));

                }
                count++;
                count2++;
            }
        }, delay, speed);
    }

    /**
     * Adds an Headertext to the Animation.
     * @param text
     */
    public void addHeader(String text) {
        headers.add(Format.format(text));
    }

    /**
     * Adds an Footertext to the Animation.
     * @param text
     */
    public void addFooter(String text) {
        footers.add(Format.format(text));
    }

    public void addHeader(String[] text) {
        for (String x : text)
            headers.add(Format.format(x + nl));
    }

    public void addHeader(List<String> text) {
        for (String x : text)
            headers.add(Format.format(x + nl));
    }

    public void addFooter(String[] text) {
        for (String x : text)
            footers.add(Format.format(x + nl));
    }

    public void addFooter(List<String> text) {
        for (String x : text)
            footers.add(Format.format(x + nl));
    }

    /**
     * SETTING to set the speed of the Animation.
     * in Minecraft TICKS
     */
    public TablistManager setSpeed(int speed) {
        this.speed = speed;
        return this;
    }

    /**
     * SETTING to set the delay of the Animation (WHEN should it start?).
     * in Minecraft TICKS
     */
    public TablistManager setDelay(int delay) {
        this.delay = delay;
        return this;
    }
}
