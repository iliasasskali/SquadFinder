# SquadFinder APP

Un cop iniciada l'app apareix la pantalla d'inici de sessió desde la qual es pot anar a la pantalla de registre, 
per afegir usuaris ho fem manualment afegint-los al fitxer users.txt ( Amb l'usuari "a", contrasenya "a" es pot entrar).

Un cop iniciada la sessió apareix la llista d'esdeveniments disponibles, amb la barra de navegació inferior es pot accedir a les diferents pantalles (llistat d'esdeveniments, llistat de grups, els meus grups i esdeveniments i SquadFinder Pro).

En el llistat d'esdeveniments, prement sobre l'últim esdeveniment ("Mitja Maratò de Barcelona") es pot entrar al detall d'aquest per veure com és el detall d'un esdeveniment.
	- Dintre el detall d'un esdeveniment si no ets participant es pot compartir o unir-se (no canvia res a part dels botons quan t'uneixes o abandones, ja que no tenim base de dades).
	- Apretant el botó per unir-se apareix botó per abandonar i botó de xat.
		- Amb el botó abandonar desapareix el botó de xat.
		- Amb el botó xat anem a la pantalla xat del grup (hem fet que respongui automaticament de forma simple)

En el llistat de grups, prement sobre el grup "Lliga de debat UPF" entrem al detall d'un grup, molt semblant al detall d'un esdeveniment.
	- Podem unir-nos i abandonar i entrar al xat per consultar amb l'organitzador.
	
En els meus Grups i Esdeveniments (meus G/E) tenim:
	- Calendari a la part superior.
	- Els meus Grups:
		- Hem afegit el grup LLiga de debat suposant que s'hi pertany.
		- Un segon grup (Admin) creat per l'usuari que utilitza l'app.
			- Entrant al grup veiem que es diferent a la vista normal de grup afegint botons.
			  Tenim un botó per editar el grup, destacar-lo, compartir i accedir al xat (Accedir al xat és l'únic funcional)
			  En el llistat d'usuaris es te l'opció d'eliminar usuaris o sortir del grup passant a ser admin un altre membre.

En la pantalla PRO només tenim una explicació de que és i un botó amb el que començar el període de prova.

Moltes funcionalitats només estan com a disseny ja que sense base de dades (falta de temps i coneixement) no es poden aplicar.
