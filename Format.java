package dev.strace.tablist;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Format {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * formats the String into colored minecraft string, also formats hexcolor
     * codes.
     *
     * @param msg the string which is being formatted.
     * @return cool string.
     */

    public static TextComponent format(String msg) {
        String ver = Bukkit.getVersion();
        if (ver.contains("1.19")) {
            if (msg.contains("#")) {
                Matcher match = pattern.matcher(msg);
                while (match.find()) {
                    String color = msg.substring(match.start(), match.end());
                    msg = msg.replace(color, TextColor.fromHexString(color) + "");
                    match = pattern.matcher(msg);
                }
            }
        }
        return LegacyComponentSerializer.legacy('&').deserialize(msg);
    }

}
