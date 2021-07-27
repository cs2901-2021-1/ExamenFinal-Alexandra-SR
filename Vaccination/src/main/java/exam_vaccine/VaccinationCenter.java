package exam_vaccine;

public class VaccinationCenter {
    Integer id;
    String address;
    int numberPartialVaccines;
    int numberFullVaccines;
    static final  Integer PEOPLE = 22935533;

    public VaccinationCenter(Integer id, String address) {
        this.id = id;
        this.address = address;
        this.numberFullVaccines= 0;
        this.numberPartialVaccines =0;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberPartialVaccines() {
        return numberPartialVaccines;
    }

    public void setNumberPartialVaccines(int numberPartialVaccines) {
        this.numberPartialVaccines = numberPartialVaccines;
    }

    public int getNumberFullVaccines() {
        return numberFullVaccines;
    }

    public void setNumberFullVaccines(int numberFullVaccines) {
        this.numberFullVaccines = numberFullVaccines;
    }



    public float advace() {
        return (float) 100*(getNumberPartialVaccines()+getNumberFullVaccines())/PEOPLE;
    }

    public float coverage() {
        return (float) 100*getNumberFullVaccines()/PEOPLE;
    }


    public void morePartial(int number) {
        numberPartialVaccines += number;
        var system = new VaccinationInfo();
        system.partialVaccination(number);
    }

    public void moreComplete(int number) {
        numberFullVaccines += number;
        var system = new VaccinationInfo();
        system.completeVaccination(number);

    }


    public VaccinationCenter() {
    }
}
