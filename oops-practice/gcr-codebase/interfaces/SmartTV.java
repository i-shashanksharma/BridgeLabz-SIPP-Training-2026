interface StreamingService {

    void streamMovie();

    default void showSubscriptionDetails() {
        System.out.println("Streaming Subscription Active");
    }
}

interface GamingService {

    void playGame();

    default void showSubscriptionDetails() {
        System.out.println("Gaming Subscription Active");
    }
}

class SmartTV implements StreamingService, GamingService {

    String[] movies = {
            "Avengers",
            "Interstellar",
            "Avatar"
    };

    String[] games = {
            "FIFA",
            "Minecraft",
            "PUBG"
    };

    public void streamMovie() {
        System.out.println("Streaming Movies");
        for (String movie : movies)
            System.out.println(movie);
    }

    public void playGame() {
        System.out.println("Available Games");
        for (String game : games)
            System.out.println(game);
    }

    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        tv.showSubscriptionDetails();
        tv.streamMovie();
        tv.playGame();
    }
}