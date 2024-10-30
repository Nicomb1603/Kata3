public class TitleTypeMapper {
    public static Title.TitleType map(String value) {
        return switch (value.toLowerCase()) {
            case "videogame" -> Title.TitleType.VideoGame;
            case "tvpilot" -> Title.TitleType.TvPilot;
            case "movie" -> Title.TitleType.Movie;
            case "tvseries" -> Title.TitleType.TvSeries;
            case "tvminiseries" -> Title.TitleType.TvMiniSeries;
            case "short" -> Title.TitleType.Short;
            case "tvspecial" -> Title.TitleType.TvSpecial;
            case "tvshort" -> Title.TitleType.TvShort;
            case "video" -> Title.TitleType.Video;
            case "tvmovie" -> Title.TitleType.TvMovie;
            case "tvepisode" -> Title.TitleType.TvEpisode;
            default -> throw new IllegalArgumentException("Unknown title type: " + value);
        };
    }
}
