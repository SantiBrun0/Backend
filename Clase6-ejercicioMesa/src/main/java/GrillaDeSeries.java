public class GrillaDeSeries implements IGrillaDeSeries {

    @Override
    public String getSeries(Serie serie) {
        return "www." + serie.nombre() + ".com";
    }

}
