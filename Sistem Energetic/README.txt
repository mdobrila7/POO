Dobrila Madalin 334CA - Etapa1

Pentru parsare input si output am creeat packetul io:
    Acesta contine 2 clase Input si Output care se muleaza pentru parsarea 
	fisierelor date si a outputului folosind API-ul Jackson.
    De asemenea acest packet mai contine un Reader si un Writter:
        - Readerul intoarce, de la un JSON, un factory pentru consumatori/desitribuitori si updateuri.
        - Writerul Scrie sub forma unui JSON rezultatul simularii

Pachetul entity contine entitatiile necesare pentru simularea jocului, impreuna cu o parte din logica implementata in acestea:
    - Contractul incheiat intre distribuitor si consumator
    - Distributor, manageriaza contracte
    - Consumer, cauta cel mai bun contract

In pachetul game se afla logica jocului:
    - In entity am specificat mai sus
    - Clasa game pune la dispozitie metode pentru desfasurarea rundelor si updatarea datelor

Patternuri:
    Singleton pentru clasa Game
    Factory pentru clasa Anonyma ce implementeaza IGameFactory ce imi ofera metode ce creeaza obiectele
        dorite din Singleton.
