package software.ulpgc.es.model;

public class Title {

        private final String title;
        private final int year;
        private final int duration;
        private final String genre;

        public Title(String title, int year, int duration, String genre) {
            this.title = title;
            this.year = year;
            this.duration = duration;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public int getYear() {
            return year;
        }

        public int getDuration() {
            return duration;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "software.ulpgc.es.model.Title{" +
                    "title='" + title + '\'' +
                    ", year=" + year +
                    ", duration=" + duration +
                    ", genre='" + genre + '\'' +
                    '}';
        }

}
