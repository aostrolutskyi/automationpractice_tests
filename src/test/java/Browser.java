import configuration.BrowserList;

public abstract class Browser {
    public static String[] setUpBrowser() {
        return BrowserList.list;
    }

}
