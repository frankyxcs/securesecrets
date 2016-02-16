package eventbus;

/**
 * Created on 04/02/2016.
 */
public class AppNavigationEvents {

    public static class EventShowCategoriesPage {
    }

    public static class EventShowPassCodePage {
    }

    public static class EventShowRecordsForId {
        final int id;

        public EventShowRecordsForId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public static class EventShowRecordDetails{
        final int id;
        public EventShowRecordDetails(int id){
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
