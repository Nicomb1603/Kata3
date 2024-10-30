public class TitleTypeMapper {
    public static Title.TitleType map(String value) {
        switch (value.toLowerCase()) {
            case "videogame": return Title.TitleType.VideoGame;
            case "tvpilot": return Title.TitleType.TvPilot;
            case "movie": return Title.TitleType.Movie;
            case "tvseries": return Title.TitleType.TvSeries;
            case "tvminiseries": return Title.TitleType.TvMiniSeries;
            case "short": return Title.TitleType.Short;
            case "tvspecial": return Title.TitleType.TvSpecial;
            case "tvshort": return Title.TitleType.TvShort;
            case "video": return Title.TitleType.Video;
            case "tvmovie": return Title.TitleType.TvMovie;
            case "tvepisode": return Title.TitleType.TvEpisode;
            default: throw new IllegalArgumentException("Unknown title type: " + value);
        }
    }
}
