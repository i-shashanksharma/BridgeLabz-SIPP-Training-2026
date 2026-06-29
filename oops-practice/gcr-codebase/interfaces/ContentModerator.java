interface TextModeration {

    void checkOffensiveContent(String post);

    default void displayModerationPolicy() {
        System.out.println("No offensive language allowed.");
    }

    static boolean containsRestrictedWords(String post) {
        String text = post.toLowerCase();
        return text.contains("bad") || text.contains("hate");
    }
}

interface SpamDetection {

    void checkSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam content is prohibited.");
    }
}

class ContentModerator implements TextModeration, SpamDetection {

    public void checkOffensiveContent(String post) {
        if (TextModeration.containsRestrictedWords(post))
            System.out.println(post + " -> Offensive Post");
    }

    public void checkSpam(String post) {
        if (post.toLowerCase().contains("buy now") || post.toLowerCase().contains("click here"))
            System.out.println(post + " -> Spam Post");
    }

    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static void main(String[] args) {

        String[] posts = {
                "Welcome everyone",
                "Buy now and save",
                "I hate this",
                "Click here to win",
                "Have a nice day"
        };

        ContentModerator cm = new ContentModerator();

        cm.displayModerationPolicy();

        for (String post : posts) {
            if (post.toLowerCase().contains("buy now") || post.toLowerCase().contains("click here"))
                cm.checkSpam(post);
            else if (TextModeration.containsRestrictedWords(post))
                cm.checkOffensiveContent(post);
            else
                System.out.println(post + " -> Valid Post");
        }
    }
}