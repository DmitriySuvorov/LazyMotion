import initwebdriver.StartFFBrowser;

public class navigation {
    public static void main(String[] args)  {
        StartFFBrowser OpenSiebel = new StartFFBrowser("http://192.168.15.92/", "fins oui",
                                                        "DSUVOROV", "DSUVOROV");
        OpenSiebel.LoginToURLApp();
        OpenSiebel.CreateNewAdmProject();

    }
}
