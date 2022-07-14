# Tablist-Paper-1.19
A Tablist "Manager" to create awsome looking and Animated Tablist.


<h3>1) First you need to create a manager in the onEnable method.</h3><br>
    
    private TablistManager manager;

    @Override
    public void onEnable() {
        manager = new TablistManager(this);
        registerTablist(); // Ways to create this scroll further down.
    }


<h3>2) After you created the manager, you can now use it to decorate the Tablist.</h3>
<br>

  <b>Variant #1 One Line. </b>
  -> manager.nl is equal to "\n" which says newline basically.
    
    private void registerTablist() {


        manager.addHeader("&6&lTwexMC" + manager.nl + "&7Online: &e" + "[online]" + " Spieler" + manager.nl + "");
        manager.addHeader("&e&lTwexMC" + manager.nl + "&7Online: &6" + "[online]" + " Spieler" + manager.nl + "");
        manager.addFooter("" + manager.nl + "&6Game: &e" + "[game]" + "  " + "&6Coins: &e" + 0 + manager.nl + "&7Have Fun!!");
        manager.addFooter("" + manager.nl + "&eGame: &6" + "[game]" + "  " + "&eCoins: &6" + 0 + manager.nl + "&7Have Fun!");
        manager.showTab();

    }

    
   <b>Variant #2 String[]</b>
    
    private void registerTablist() {


        String[] head = new String[]{
                "&6&lTwexMC",
                "&7Online: &e" + "[online]" + " Spieler",
                ""
        };
        String[] foot = new String[]{
                "",
                "&eGame: &6" + "[game]" + "&eCoins: &6" + 0,
                "&7Have Fun!"
        };
        manager.addHeader(head);
        manager.addFooter(foot);
        manager.showTab();
    }

    
   <b>Variant #3 List/ArrayList</b>
  Personal Favourite (Looks the cleanest).
    
    private void registerTablist() {

        List<String> head = new ArrayList<>();
        head.add("&6&lTwexMC");
        head.add("&7Online: &e" + "[online]" + " Spieler");
        head.add("");

        List<String> head2 = new ArrayList<>();
        head2.add("&e&lTwexMC");
        head2.add("&7Online: &6" + "[online]" + " Spieler");
        head2.add("");

        List<String> foot = new ArrayList<>();
        foot.add("");
        foot.add("&eGame: &6" + "[game]" + "  " + "&eCoins: &6" + 0);
        foot.add("&7Have FUN!");

        List<String> foot2 = new ArrayList<>();
        foot2.add("");
        foot2.add("&6Game: &e" + "[game]" + "  " + "&6Coins: &e" + 0);
        foot2.add("&7Have Fun!!!!");

        manager.addHeader(head);
        manager.addHeader(head2);
        manager.addFooter(foot);
        manager.addFooter(foot2);
        manager.showTab();
    }
<h3>3) You may want to set the Animation speed and delay.</h3>
<br>
        
        manager.setSpeed(40);
        manager.setDelay(0);
        
Well this is it. Enjoy.
