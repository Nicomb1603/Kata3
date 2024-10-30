// Poner todos los atributos
// isAdult controlar como booleano y debe entrar en el record como booleano
// Genres == Enum
public record Title(String id, Title.TitleType titleType, String primaryTitle, String originalTitle, boolean isAdult, int startYear, int endYear, int runtimeMinutes, String genres) {

    public enum TitleType {
        VideoGame,
        TvPilot,
        Movie,
        TvSeries,
        TvMiniSeries,
        Short,
        TvSpecial,
        TvShort,
        Video,
        TvMovie,
        TvEpisode,
    }


}
