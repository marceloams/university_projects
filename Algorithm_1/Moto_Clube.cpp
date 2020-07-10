#include <iostream>
#include <cstring>
#include <fstream>
#include <windows.h>
#include <clocale>

using namespace std;

fstream arquivo;

struct Membro{
	
	int idade, placa2;
	char nome[40],cpf[1000],RG[1000],cargo[30], placa1[100], cidade[50], sexo[1000], sangue[1000], Rh[1000], end[250] ;
	bool excluido;
};

Membro MC;

void cadastrar(){
	system("cls");
	
	cout << "Entre com o nome do membro: ";
	cin.getline(MC.nome,40);
	do{
		cout << "Entre com a idade: ";
		cin >> MC.idade;
	}while(MC.idade < 1 || MC.idade > 150);  
	cout << "Entre com o sexo(M, para Masculino ou F, para feminino): ";
	cin.ignore();
	cin.getline(MC.sexo,1000);
	if(strcmp(MC.sexo,"M")!=0 && strcmp(MC.sexo,"F")!=0){
		cout << "Entre com o sexo(M, para Masculino ou F, para feminino): ";
		cin.getline(MC.sexo,1000);
	}
	do{
		cout << "Entre com o cpf (somente numeros): ";
       	cin.getline(MC.cpf,1000);
	}while(strlen(MC.cpf)>15);
	do{
		cout << "Entre com o RG (somente numeros): ";
       	cin.getline(MC.RG,1000);
	}while(strlen(MC.RG)>16 && strlen(MC.RG)<1);
	do{
		cout << "Entre com o tipo sanguineo (A, B, AB ou O): ";
		cin.getline(MC.sangue,1000);
	}while(strcmp(MC.sangue,"A")!=0 &&  strcmp(MC.sangue,"B")!=0 && strcmp(MC.sangue,"AB")!=0 && strcmp(MC.sangue,"O")!=0);
	do{
		cout << "Entre com o RH (+, para positivo ou -, para negativo):";
		cin.getline(MC.Rh,1000);
	}while(strcmp(MC.Rh,"+")!=0 && strcmp(MC.Rh,"-")!=0);
	cout << "Entre com a cidade de nascimento: ";
    cin.getline(MC.cidade,50);
    cout << "Entre com o endereco de moradia: ";
    cin.getline(MC.end,250);
    do{
		cout << "Entre com 3 letras da placa da moto: ";
		cin.getline(MC.placa1,100);
	}while(strlen(MC.placa1)!=3);
	do{
		cout << "Entre com os 4 numeros da placa: ";
		cin >> MC.placa2;
	}while((MC.placa2<1000 || MC.placa2>9999));
	cout << "Entre com o cargo do membro no motoclube: ";
	cin.ignore();
	cin.getline(MC.cargo,30); 
	
	MC.excluido = false;
	
	arquivo.seekp(0,arquivo.end);
	arquivo.write((char *) &MC, sizeof(MC));
	
	system("pause");
	system("cls");
	cout << "Membro cadastrado com sucesso!" << endl;
	system("pause");
	
	return;
}

void pesquisar(){
	system("cls");
	
	char NM[40];
	bool encontrado = false;
	
	cout << "Entre com o nome do membro: ";
	cin.getline(NM,40);
	
	system("cls");
	
	arquivo.seekg(0,arquivo.beg);
	
	while(!arquivo.eof() && !encontrado){
		
		arquivo.read((char *) &MC, sizeof(MC));
		
		if(!arquivo.eof() && strcmp(NM,MC.nome)==0 && !MC.excluido){
				cout << "Nome: " << MC.nome << endl;
				cout << "Idade: " << MC.idade << endl;
				cout << "Sexo: ";
				if(strcmp(MC.sexo,"M")==0)
					cout << "Masculino" << endl;
				else if(strcmp(MC.sexo,"F")==0)
					cout << "Feminino" << endl;
				cout << "CPF: " << MC.cpf << endl;
				cout << "RG: " << MC.RG << endl;
				cout << "Sangue: " << MC.sangue << MC.Rh << endl;
				cout << "Cidade natal: " << MC.cidade << endl;
				cout << "Endereço: " << MC.end << endl;
				cout << "Placa da moto: " << MC.placa1 << "-" << MC.placa2 << endl;
				cout << "Cargo: " << MC.cargo << endl;
				cout << endl;
				
				system("pause");
				
				encontrado = true;
		}
	}
	
	arquivo.clear();
	
	if(!encontrado){
		cout << "Membro não encontrado!" << endl;
		system("pause");}
			
	return;
}

void listar(){
	system("cls");
	
	bool listado = false;
	
	arquivo.seekg(0,arquivo.beg);
	
	while(arquivo.read((char *) &MC, sizeof(MC))){

        if(MC.excluido == false){
			cout << "Nome: " << MC.nome << endl;
			cout << "Idade: " << MC.idade << endl;
			cout << "Sexo: ";
			if(strcmp(MC.sexo,"M")==0)
				cout << "Masculino" << endl;
			else if(strcmp(MC.sexo,"F")==0)
				cout << "Feminino" << endl;
		   	cout << "CPF: " << MC.cpf << endl;
			cout << "RG: " << MC.RG << endl;
			cout << "Sangue: " << MC.sangue << MC.Rh << endl;
			cout << "Cidade natal: " << MC.cidade << endl;
			cout << "Endereço: " << MC.end << endl;
			cout << "Placa da moto: " << MC.placa1 << "-" << MC.placa2 << endl;
			cout << "Cargo: " << MC.cargo << endl;
			cout << endl;
			listado=true;
		}
	}
	
	if(listado==false){
		cout << "Não há membro cadastrado!" << endl; 
	}
	
	system("pause");
	arquivo.clear();
	
	return;
}

void editar(){
	system("cls");
	
	char NM[40], alt[50];
	bool encontrado = false;
	
	cout << "Entre com o nome do membro que deseja alterar os dados: ";
	cin.getline(NM,40);
	system("cls");
	arquivo.seekg(0,arquivo.beg);
	
	while(!arquivo.eof() && !encontrado){
		
		arquivo.read((char *) &MC, sizeof(MC));
		
		if(!arquivo.eof() && strcmp(NM,MC.nome)==0 && !MC.excluido){
			
			cout << "Dados do membro: " << endl;
			cout << endl;
		    cout << "	Nome: " << MC.nome << endl;    			
			cout << "	Idade: " << MC.idade << endl;
			cout << "	Sexo: ";
			if(strcmp(MC.sexo,"M")==0)
				cout << "Masculino" << endl;
			else if(strcmp(MC.sexo,"F")==0)
				cout << "Feminino" << endl;
			cout << "	CPF: " << MC.cpf << endl;
			cout << "	RG: " << MC.RG << endl;
			cout << "	Sangue: " << MC.sangue << MC.Rh << endl;
			cout << "	Cidade natal: " << MC.cidade << endl;
			cout << "	Endereço: " << MC.end << endl;
			cout << "	Placa da moto: " << MC.placa1 << "-" << MC.placa2 << endl;
			cout << "	Cargo: " << MC.cargo << endl;
			cout << endl;
			cout << "Digite o numero de acordo com o que deseja alterar: " << endl;
			    cout << endl;
		    cout << "	0- Sair;" << endl;
		    cout << "	1- Nome;" << endl;
		    cout << "	2- Idade;" << endl;
		    cout << "	3- Sexo;" << endl;
		    cout << "	4- CPF;" << endl;
		    cout << "	5- RG;" << endl;
		    cout << "	6- Sangue;" << endl;
		    cout << "	7- Cidade natal;" << endl;
		    cout << "	8- Endereco;" << endl;
		    cout << "	9- Placa da moto;" << endl;
		    cout << "	10- Cargo;" << endl;
			cin.getline(alt,50);
			
			while(strcmp(alt,"0")!=0 && strcmp(alt,"1")!=0 && strcmp(alt,"2")!=0 && strcmp(alt,"3")!=0 && strcmp(alt,"4")!=0 && strcmp(alt,"5")!=0 && strcmp(alt,"6")!=0 && strcmp(alt,"7")!=0 && strcmp(alt,"8")!=0 && strcmp(alt,"9")!=0 && strcmp(alt,"10")!=0){
			    system("cls");
				cout << "Dados do membro: " << endl;
				cout << endl;
			    cout << "	Nome: " << MC.nome << endl;    			
				cout << "	Idade: " << MC.idade << endl;
				cout << "	Sexo: ";
				if(strcmp(MC.sexo,"M")==0)
					cout << "Masculino" << endl;
				else if(strcmp(MC.sexo,"F")==0)
					cout << "Feminino" << endl;
				cout << "	CPF: " << MC.cpf << endl;
				cout << "	RG: " << MC.RG << endl;
				cout << "	Sangue: " << MC.sangue << MC.Rh << endl;
				cout << "	Cidade natal: " << MC.cidade << endl;
				cout << "	Endereço: " << MC.end << endl;
				cout << "	Placa da moto: " << MC.placa1 << "-" << MC.placa2 << endl;
				cout << "	Cargo: " << MC.cargo << endl;
				cout << endl;
				cout << "Digite o numero de acordo com o que deseja alterar: " << endl;
			    cout << endl;
			    cout << "	0- Sair;" << endl;
			    cout << "	1- Nome;" << endl;
			    cout << "	2- Idade;" << endl;
			    cout << "	3- Sexo;" << endl;
			    cout << "	4- CPF;" << endl;
			    cout << "	5- RG;" << endl;
			    cout << "	6- Sangue;" << endl;
			    cout << "	7- Cidade natal;" << endl;
			    cout << "	8- Endereco;" << endl;
			    cout << "	9- Placa da moto;" << endl;
			    cout << "	10- Cargo;" << endl;
				cin.getline(alt,50);
			}		
			
			if(strcmp(alt,"1")==0){
				system("cls");
				cout << "Entre com o novo nome do membro: ";
				cin.getline(MC.nome,40);
			}
			if(strcmp(alt,"2")==0){
				do{
					system("cls");
					cout << "Entre com a nova idade: ";
					cin >> MC.idade;
				}while(MC.idade < 1 || MC.idade > 150); 
			}
			if(strcmp(alt,"3")==0){
				system("cls");
				cout << "Entre com o novo sexo(M, para Masculino ou F, para feminino): ";
				cin.ignore();
				cin.getline(MC.sexo,1000);
				if(strcmp(MC.sexo,"M")!=0 && strcmp(MC.sexo,"F")!=0){
					system("cls");
					cout << "Entre com o novo sexo(M, para Masculino ou F, para feminino): ";
					cin.getline(MC.sexo,1000);
				}
			}
			if(strcmp(alt,"4")==0){
				do{
					system("cls");
					cout << "Entre com o novo cpf (somente numeros): ";
       				cin.getline(MC.cpf,1000);
				}while(strlen(MC.cpf)>15);
	  	  	  }
			if(strcmp(alt,"5")==0){
				do{
					system("cls");
					cout << "Entre com o novo RG (somente numeros): ";
       				cin.getline(MC.RG,1000);
				}while(strlen(MC.RG)>16 && strlen(MC.RG)<1);
			}
			if(strcmp(alt,"6")==0){
				do{
					system("cls");
		   	   		cout << "Entre com o novo tipo sanguineo (A, B, AB ou O): ";
				   	cin.getline(MC.sangue,1000);
				}while(strcmp(MC.sangue,"A")!=0 &&  strcmp(MC.sangue,"B")!=0 && strcmp(MC.sangue,"AB")!=0 && strcmp(MC.sangue,"O")!=0);
				do{
					system("cls");
					cout << "Entre com o novo RH (+, para positivo ou -, para negativo):";
					cin.getline(MC.Rh,1000);
				}while(strcmp(MC.Rh,"+")!=0 && strcmp(MC.Rh,"-")!=0);
			}
			if(strcmp(alt,"7")==0){
				system("cls");
				cout << "Entre com a nova cidade de nascimento: ";
    			cin.getline(MC.cidade,50);
			}	  
			if(strcmp(alt,"8")==0){
				system("cls");
				cout << "Entre com o novo endereco de moradia: ";
    			cin.getline(MC.end,250);
			}
			if(strcmp(alt,"9")==0){
				do{
					system("cls");
					cout << "Entre com 3 letras da placa da moto: ";
					cin.getline(MC.placa1,100);
				}while(strlen(MC.placa1)!=3);
				do{
					system("cls");
					cout << "Entre com os 4 numeros da placa: ";
					cin >> MC.placa2;
				}while((MC.placa2<1000 || MC.placa2>9999));
			}
			if(strcmp(alt,"10")==0){
				system("cls");
				cout << "Entre com o novo cargo do membro no motoclube: ";
				cin.getline(MC.cargo,30); 
			}	  	
			
			arquivo.seekp(arquivo.tellp() - sizeof(MC), arquivo.beg);
			arquivo.write((char *) &MC, sizeof(MC));
			
			system("cls");
			cout << "Dado editado com sucesso!" << endl;
			
			system("pause");	
			encontrado = true;
		}
	}
	
	arquivo.clear();
	
	if(!encontrado){
		cout << "Membro nao encontrado!" << endl;
		system("pause");}
			
	return;
}

void excluir(){
	system("cls");
	
	char NM[40], alt[50];
	bool encontrado = false;
	
	cout << "Entre com o nome do membro que deseja excluir os dados: ";
	cin.getline(NM,40);
	system("cls");
	arquivo.seekg(0,arquivo.beg);
	
	while(!arquivo.eof() && !encontrado){
		
		arquivo.read((char *) &MC, sizeof(MC));
		
		if(!arquivo.eof() && strcmp(NM,MC.nome)==0 && !MC.excluido){
			
			do{
				cout << "Deseja mesmo exluir os dados deste membro(sim ou nao)? "; 
		    	cin.getline(alt,50);
			}while(strcmp(alt,"sim")!=0 && strcmp(alt,"nao")!=0);
			if(strcmp(alt,"sim")==0){
				system("cls");
				cout << "Membro excluído com sucesso!" << endl;
				MC.excluido = true;	
				arquivo.seekp(arquivo.tellp() - sizeof(MC), arquivo.beg);
				arquivo.write((char *) &MC, sizeof(MC));
			}
			
			system("pause");
				
			encontrado = true;
		}
	}
	
	arquivo.clear();
	
	if(!encontrado){
		cout << "Membro nao encontrado!" << endl;
		system("pause");}
		
	return;
	
}

void extra1(){
	
	char link[] = "start chrome www.revistamotoclubes.com.br/2008_06/Materia_2008_06_02_Etica.htm";
	
	system(link);
	
	return;
}

void extra2(){
	
	ofstream myfile;
	myfile.open ("membros.txt");
	myfile << "#### MEMBROS CADASTRADOS ####" << endl;
	myfile << endl;
	arquivo.seekg(0,arquivo.beg);
	
	while(arquivo.read((char *) &MC, sizeof(MC))){

        if(MC.excluido == false){

			myfile << "Nome: " << MC.nome << endl;
			myfile << "Idade: " << MC.idade << endl;
	   	   	myfile << "Sexo: ";
			if(strcmp(MC.sexo,"M")==0)
				myfile << "Masculino" << endl;
			else if(strcmp(MC.sexo,"F")==0)
				myfile << "Feminino" << endl;
			myfile << "CPF: " << MC.cpf << endl;
			myfile << "RG: " << MC.RG << endl;
			myfile << "Sangue: " << MC.sangue << MC.Rh << endl;
			myfile << "Cidade natal: " << MC.cidade << endl;
			myfile << "Endereço: " << MC.end << endl;
			myfile << "Placa da moto: " << MC.placa1 << "-" << MC.placa2 << endl;
			myfile << "Cargo: " << MC.cargo << endl;
			myfile << endl;
		}
	}
	
	myfile.close();
	system("pause");
	arquivo.clear();

	return;
	}



int main(){
	setlocale(LC_ALL, "Portuguese");
	
	arquivo.open("Motoclube.txt", ios::in | ios::out | ios::binary | ios::ate);
	
	if(!arquivo.is_open())
		arquivo.open("Motoclube.txt", ios::in | ios::out | ios::trunc | ios::binary);
		
	char q[1000];
	
	do{
		system("cls");
		cout << "------------------------------------------------------------------------------------------------------------------------" << endl;
	 	cout << "################################### BEM-VINDO AO CADASTRO DE MEMBROS DO MOTO CLUBE #####################################" << endl; 
		cout << "------------------------------------------------------------------------------------------------------------------------" << endl;
		cout << endl;        
		cout << "Digite:" << endl;
		cout << "       0- Sair;" << endl;
		cout << "       1- Cadastrar;" << endl;
		cout << "       2- Pesquisar;" << endl;
		cout << "       3- Listar;" << endl;
		cout << "       4- Editar;" << endl;
		cout << "       5- Excluir;" << endl;
		cout << "       6- Abrir site com o Código Nacional de Ética dos Moto Clubes;" << endl;
		cout << "       7- Abrir bloco de notas com os dados dos membros cadastrados." << endl;
		cin.getline(q,1000);
	
		if(strcmp(q,"1")==0)
			cadastrar();
		if(strcmp(q,"2")==0)
			pesquisar();
		if(strcmp(q,"3")==0)
			listar();
		if(strcmp(q,"4")==0)
			editar();
		if(strcmp(q,"5")==0)
			excluir();
		if(strcmp(q,"6")==0)
			extra1();
		if(strcmp(q,"7")==0){
			extra2();
			system("START membros.txt");
		}
	
	}while(strcmp(q,"0")!=0);
	
	arquivo.close();
	
	return 0;
}