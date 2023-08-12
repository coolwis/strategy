public class Main {
    public static void main(String[] args) {

        Director director = new Director();
        director.addProject("여행사", new Client() {
                    @Override
                    public Program[] run() {
                        FrontEnd frontEnd = new FrontEnd<Client>() {
                            @Override
                            void setData(Client paper) {
                                library = paper.library;
                                language = paper.language;
                            }
                        };
                        programmer = frontEnd;
                        return new Program[]{frontEnd.getProgram(this)};
                    }
                }

        );
        director.runProject("여행사");


        //serverClient pager
        director.addProject("여행사풀스택", new SeverClient(){
            @Override
            public Program[] run() {
                //return new Program[0];
                FrontEnd frontEnd =new FrontEnd<SeverClient>() {
                    @Override
                    void setData(SeverClient paper) {
                        language = paper.frontEndLanguage;
                    }
                };
                frontEndProgrammer = frontEnd;

                BackEnd backEnd =new BackEnd<SeverClient>() {
                    @Override
                    void setData(SeverClient paper) {
                        server =paper.server;
                        backEndLanguage = paper.backEndLanguage;
                    }
                };
                backEndProgrammer  = backEnd;

                return new Program[]{
                        frontEnd.getProgram(this),
                        backEnd.getProgram(this)
                };
            }
        });
        director.runProject("여행사풀스택");

    }
}