import spec.Language;
import spec.Library;


public abstract class Client implements Paper {
    Library library = new Library("vue.js");
    Language language = new Language("js");
    Programmer programmer;

    public void setProgram(Programmer programmer) {
        this.programmer = programmer;
    }

}

