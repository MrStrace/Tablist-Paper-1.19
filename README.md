# Tablist-Paper-1.19
A Tablist "Manager" to create awsome looking and Animated Tablist.

<div class="init">
    First you need to create a manager in the onEnable method.
    <div class="code">
private TablistManager manager;

    @Override
    public void onEnable() {
        manager = new TablistManager(this);
        registerTablist(); // Ways to create this scroll further down.
    }
    </div>
</div>

After you created the manager, you can now use it to decorate the Tablist.

<div class="code">
    
    /*
    Variant #1 One Line.
     */
    private void registerTablist() {


        manager.addHeader("&6&lTwexMC" + manager.nl + "&7Online: &e" + Bukkit.getOnlinePlayers().size() + 1 + " Spieler" + manager.nl + "");
        manager.addHeader("&e&lTwexMC" + manager.nl + "&7Online: &6" + Bukkit.getOnlinePlayers().size() + 1 + " Spieler" + manager.nl + "");
        manager.addFooter("" + manager.nl + "&6Game: &e" + Bukkit.motd().compact() + "  " + "&6Coins: &e" + 0 + manager.nl + "&7Viel Spaß!");
        manager.addFooter("" + manager.nl + "&eGame: &6" + Bukkit.motd().compact() + "  " + "&eCoins: &6" + 0 + manager.nl + "&7Viel Spaß!");
        manager.showTab();

    }

    /*
    Variant #2 String[].
    */
    private void registerTablist2() {


        String[] head = new String[]{
                "&6&lTwexMC",
                "&7Online: &e" + Bukkit.getOnlinePlayers().size() + 1 + " Spieler",
                ""
        };
        String[] foot = new String[]{
                "",
                "&eGame: &6" + Bukkit.motd().compact() + "  " + "&eCoins: &6" + 0,
                "&7Viel Spaß!"
        };
        manager.addHeader(head);
        manager.addFooter(foot);
        manager.showTab();
    }

    /*
    Variant #3 List/ArrayList
    Personal Favourite (Looks the cleanest).
     */
    private void registerTablist3() {

        List<String> head = new ArrayList<>();
        head.add("&6&lTwexMC");
        head.add("&7Online: &e" + Bukkit.getOnlinePlayers().size() + 1 + " Spieler");
        head.add("");

        List<String> foot = new ArrayList<>();
        foot.add("");
        foot.add("&eGame: &6" + Bukkit.motd().compact() + "  " + "&eCoins: &6" + 0);
        foot.add("&7Viel Spaß!");

        manager.addHeader(head);
        manager.addFooter(foot);
        manager.showTab();
    }
</div>
