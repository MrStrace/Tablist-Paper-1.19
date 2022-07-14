package dev.strac.prettytwex.manager;

import dev.strac.prettytwex.Main;
import dev.strac.prettytwex.utils.Format;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TablistManager {
    private Main instance;
    private List<String> headers = new ArrayList<>();
    private List<String> footers = new ArrayList<>();
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

                    p.sendPlayerListHeader(Format.format(headers.get(count).replace("[online]", ""+Bukkit.getOnlinePlayers().size())));
                    p.sendPlayerListFooter(Format.format(footers.get(count2).replace("[online]", ""+Bukkit.getOnlinePlayers().size())));

                }
                count++;
                count2++;
            }
        }, delay, speed);
    }

    /**
     * Adds an Headertext to the Animation.
     *
     * @param text
     */
    public void addHeader(String text) {
        headers.add(text);
    }

    /**
     * Adds an Footertext to the Animation.
     *
     * @param text
     */
    public void addFooter(String text) {
        footers.add(text);
    }

    public void addHeader(String[] text) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String x : text) {
            i++;
            if (text.length >= i)
                builder.append(x + nl);
            else builder.append(x);
        }
            headers.add(builder.toString());
    }

    public void addHeader(List<String> text) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String x : text) {
            i++;
            if (text.size() > i)
                builder.append(x + nl);
            else builder.append(x);
        }
        headers.add(builder.toString());
    }

    public void addFooter(String[] text) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String x : text) {
            i++;
            if (text.length >= i)
                builder.append(x + nl);
            else builder.append(x);
        }
        footers.add(builder.toString());
    }

    public void addFooter(List<String> text) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (String x : text) {
            i++;
            if (text.size() > i)
                builder.append(x + nl);
            else builder.append(x);
        }
        footers.add(builder.toString());
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
