public class GrillaDeSeriesProxy implements IGrillaDeSeries {

    private final GrillaDeSeries grillaDeSeries = new GrillaDeSeries();
    private int cantVisitas;

    @Override
    public String getSeries(Serie serie) {
        cantVisitas += 1;
        if (cantVisitas > 5) return "La serie ya ha sido vista mas de 5 veces";
        return grillaDeSeries.getSeries(serie);
    }

}
