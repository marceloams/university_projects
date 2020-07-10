#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <conio.h>

FILE *file;

struct nod
{
    char idade[100];
	int qtd,fem,masc,fem_nat,fem_nonat,masc_nat,masc_nonat,fem_br,fem_am,fem_ng,masc_br,masc_am,masc_ng,fem_bx,fem_md,fem_at,masc_bx,masc_md,masc_at;
	struct nod *esq;
	struct nod *dir;
};
typedef struct nod* nodptr;


struct palavra
{
    char idade[100];
};

void quickSort(struct palavra lista2[], int i, int j)
{
    int pivo,esq,dir;
    char x[100];

    esq = i;
    dir = j;
    pivo = (int)((esq + dir)/2.0);

    do
    {
        while(strcmp(lista2[esq].idade,lista2[pivo].idade)==-1)
            esq++;
        while(strcmp(lista2[dir].idade,lista2[pivo].idade)==1)
            dir--;
        if(esq <= dir)
        {
            strcpy(x,lista2[esq].idade);
            strcpy(lista2[esq].idade,lista2[dir].idade);
            strcpy(lista2[dir].idade,x);
            esq++;
            dir--;
        }
    }while(esq<=dir);

    if(dir-i>=0)
    {
        quickSort(lista2,i,dir);
    }
    if(j-esq>=0)
    {
        quickSort(lista2,esq,j);
    }
}

void alfabetic(nodptr *lista)
{
    system("cls");

    struct palavra *lista2;

    int i;

    nodptr p = *lista;
    nodptr d = p->dir;

    nodptr e = p;
    nodptr f = e->dir;
    nodptr h = e->esq;
    nodptr g = f->dir;

    lista2 = (struct palavra*) malloc(4*sizeof(struct palavra));


    for(i=0; i<4; i++)
    {
        strcpy(lista2[i].idade,p->idade);
        p = d;
        d = p->dir;
    }

    quickSort(lista2,0,3);

    e->dir=e;
    e->esq=e;
    f->dir=f;
    f->esq=f;
    g->dir=g;
    g->esq=g;
    h->dir=h;
    h->esq=h;


    nodptr x;
    nodptr w;
    nodptr y;
    nodptr z;

    if(strcmp(lista2[0].idade,e->idade)==0)
        x = e;
    else if(strcmp(lista2[0].idade,f->idade)==0)
        x = f;
    else if(strcmp(lista2[0].idade,g->idade)==0)
        x = g;
    else if(strcmp(lista2[0].idade,h->idade)==0)
        x = h;

    if(strcmp(lista2[1].idade,e->idade)==0)
        w = e;
    else if(strcmp(lista2[1].idade,f->idade)==0)
        w = f;
    else if(strcmp(lista2[1].idade,g->idade)==0)
        w = g;
    else if(strcmp(lista2[1].idade,h->idade)==0)
        w = h;

    if(strcmp(lista2[2].idade,e->idade)==0)
        y = e;
    else if(strcmp(lista2[2].idade,f->idade)==0)
        y = f;
    else if(strcmp(lista2[2].idade,g->idade)==0)
        y = g;
    else if(strcmp(lista2[2].idade,h->idade)==0)
        y = h;

    if(strcmp(lista2[3].idade,e->idade)==0)
        z = e;
    else if(strcmp(lista2[3].idade,f->idade)==0)
        z = f;
    else if(strcmp(lista2[3].idade,g->idade)==0)
        z = g;
    else if(strcmp(lista2[3].idade,h->idade)==0)
        z = h;

    x->dir=w;
    x->esq=z;
    w->dir=y;
    w->esq=x;
    y->dir=z;
    y->esq=w;
    z->dir=x;
    z->esq=y;

   *lista = x;
}


void criad_infant(nodptr *lista)
{
    nodptr p;

    p = (nodptr)malloc(sizeof(struct nod));
    strcpy(p->idade,"Infantil");
    p->qtd = 0;
    p->fem = 0;
    p->masc = 0;
    p->fem_nat = 0;
    p->fem_nonat = 0;
    p->masc_nat = 0;
    p->masc_nonat = 0;
    p->fem_br = 0;
    p->fem_am = 0;
    p->fem_ng = 0;
    p->masc_br = 0;
    p->masc_am = 0;
    p->masc_ng = 0;
    p->fem_bx = 0;
    p->fem_md = 0;
    p->fem_at = 0;
    p->masc_bx = 0;
    p->masc_md = 0;
    p->masc_at = 0;
    p->esq = p;
    p->dir = p;
    *lista = p;
}

void criad_jov(nodptr *lista)
{
    nodptr p;
    nodptr d;

    p = (nodptr)malloc(sizeof(struct nod));
    strcpy(p->idade,"Jovem");
    p->qtd=0;
    p->fem=0;
    p->masc=0;
    p->fem_nat=0;
    p->fem_nonat=0;
    p->masc_nat=0;
    p->masc_nonat=0;
    p->fem_br=0;
    p->fem_am=0;
    p->fem_ng=0;
    p->masc_br=0;
    p->masc_am=0;
    p->masc_ng=0;
    p->fem_bx=0;
    p->fem_md=0;
    p->fem_at=0;
    p->masc_bx=0;
    p->masc_md=0;
    p->masc_at=0;
    d = (*lista)->dir;
    p->esq = *lista;
    p->dir = d;
    d->esq = p;
    (*lista)->dir = (p);
}

void criad_meia(nodptr *lista)
{
    nodptr p;
    nodptr d;

    p = (nodptr)malloc(sizeof(struct nod));
    strcpy(p->idade,"Meia Idade");
    p->qtd=0;
    p->fem=0;
    p->masc=0;
    p->fem_nat=0;
    p->fem_nonat=0;
    p->masc_nat=0;
    p->masc_nonat=0;
    p->fem_br=0;
    p->fem_am=0;
    p->fem_ng=0;
    p->masc_br=0;
    p->masc_am=0;
    p->masc_ng=0;
    p->fem_bx=0;
    p->fem_md=0;
    p->fem_at=0;
    p->masc_bx=0;
    p->masc_md=0;
    p->masc_at=0;
    d = (*lista)->dir;
    p->esq = *lista;
    p->dir = d;
    d->esq = p;
    (*lista)->dir = (p);
}

void criad_terc(nodptr *lista)
{
    nodptr p;
    nodptr d;

    p = (nodptr)malloc(sizeof(struct nod));
    strcpy(p->idade,"Terceira Idade");
    p->qtd=0;
    p->fem=0;
    p->masc=0;
    p->fem_nat=0;
    p->fem_nonat=0;
    p->masc_nat=0;
    p->masc_nonat=0;
    p->fem_br=0;
    p->fem_am=0;
    p->fem_ng=0;
    p->masc_br=0;
    p->masc_am=0;
    p->masc_ng=0;
    p->fem_bx=0;
    p->fem_md=0;
    p->fem_at=0;
    p->masc_bx=0;
    p->masc_md=0;
    p->masc_at=0;
    d = (*lista)->dir;
    p->esq = *lista;
    p->dir = d;
    d->esq = p;
    (*lista)->dir = (p);
}

void criad(nodptr *lista)
{
    criad_infant(&(*lista));
    criad_jov(&(*lista));
    criad_meia(&(*lista));
    criad_terc(&(*lista));
    alfabetic(&(*lista));
}


void write(nodptr *lista)
{
    nodptr p = *lista;
    nodptr d = p->dir;
    int x,i,b=1;

    file = fopen("mortalizer2.txt","r");
        if(file != NULL)
        {
            b=0;
        }
    fclose(file);

    if(b==1)
    {
        file = fopen("mortalizer2.txt","w");
        for(i=0; i<4; i++)
        {
            if(strcmp(p->idade,"Infantil")==0)
                x = 1;
            if(strcmp(p->idade,"Jovem")==0)
                x = 2;
            if(strcmp(p->idade,"Meia Idade")==0)
                x = 3;
            if(strcmp(p->idade,"Terceira Idade")==0)
                x = 4;

            fprintf(file,"%d", x);
            fprintf(file, "\n%d", p->qtd);
            fprintf(file,"\n%d", p->fem);
            fprintf(file,"\n%d", p->masc);
            fprintf(file,"\n%d", p->fem_nat);
            fprintf(file,"\n%d", p->fem_nonat);
            fprintf(file,"\n%d", p->masc_nat);
            fprintf(file,"\n%d", p->masc_nonat);
            fprintf(file,"\n%d", p->fem_br);
            fprintf(file,"\n%d", p->fem_am);
            fprintf(file,"\n%d", p->fem_ng);
            fprintf(file,"\n%d", p->masc_br);
            fprintf(file,"\n%d", p->masc_am);
            fprintf(file,"\n%d", p->masc_ng);
            fprintf(file,"\n%d", p->fem_bx);
            fprintf(file,"\n%d", p->fem_md);
            fprintf(file,"\n%d", p->fem_at);
            fprintf(file,"\n%d", p->masc_bx);
            fprintf(file,"\n%d", p->masc_md);
            fprintf(file,"\n%d\n", p->masc_at);
            p = d;
            d = p->dir;
        }
        fclose(file);
    }
    else if(b==0)
    {
        file = fopen("mortalizer2.txt","r");
        for(i=0; i<4; i++)
        {
            fscanf(file,"%d",&x);

            if(x==1)
                strcpy(&p->idade,"Infantil");
            else if(x==2)
                strcpy(&p->idade,"Jovem");
            else if(x==3)
                strcpy(&p->idade,"Meia Idade");
            else if(x==4)
                strcpy(&p->idade,"Terceira Idade");

            fscanf(file,"%d",&p->qtd);
            fscanf(file,"%d", &p->fem);
            fscanf(file,"%d", &p->masc);
            fscanf(file,"%d", &p->fem_nat);
            fscanf(file,"%d", &p->fem_nonat);
            fscanf(file,"%d", &p->masc_nat);
            fscanf(file,"%d", &p->masc_nonat);
            fscanf(file,"%d", &p->fem_br);
            fscanf(file,"%d", &p->fem_am);
            fscanf(file,"%d", &p->fem_ng);
            fscanf(file,"%d", &p->masc_br);
            fscanf(file,"%d", &p->masc_am);
            fscanf(file,"%d", &p->masc_ng);
            fscanf(file,"%d", &p->fem_bx);
            fscanf(file,"%d", &p->fem_md);
            fscanf(file,"%d", &p->fem_at);
            fscanf(file,"%d", &p->masc_bx);
            fscanf(file,"%d", &p->masc_md);
            fscanf(file,"%d", &p->masc_at);
            p = d;
            d = p->dir;
        }
        fclose(file);
        alfabetic(&p);
    }
    (*lista = p);
}

void write_2(nodptr lista)
{
    nodptr p = lista;
    nodptr d = p->dir;
    int x,i;

    file = fopen("mortalizer2.txt","w");
    for(i=0; i<4; i++)
    {

        if(strcmp(p->idade,"Infantil")==0)
            x = 1;
        if(strcmp(p->idade,"Jovem")==0)
            x = 2;
        if(strcmp(p->idade,"Meia Idade")==0)
            x = 3;
        if(strcmp(p->idade,"Terceira Idade")==0)
            x = 4;

        fprintf(file,"%d", x);
        fprintf(file, "\n%d", p->qtd);
        fprintf(file,"\n%d", p->fem);
        fprintf(file,"\n%d", p->masc);
        fprintf(file,"\n%d", p->fem_nat);
        fprintf(file,"\n%d", p->fem_nonat);
        fprintf(file,"\n%d", p->masc_nat);
        fprintf(file,"\n%d", p->masc_nonat);
        fprintf(file,"\n%d", p->fem_br);
        fprintf(file,"\n%d", p->fem_am);
        fprintf(file,"\n%d", p->fem_ng);
        fprintf(file,"\n%d", p->masc_br);
        fprintf(file,"\n%d", p->masc_am);
        fprintf(file,"\n%d", p->masc_ng);
        fprintf(file,"\n%d", p->fem_bx);
        fprintf(file,"\n%d", p->fem_md);
        fprintf(file,"\n%d", p->fem_at);
        fprintf(file,"\n%d", p->masc_bx);
        fprintf(file,"\n%d", p->masc_md);
        fprintf(file,"\n%d\n", p->masc_at);
        p = d;
        d = p->dir;
    }
    fclose(file);
}


void registrar_pt1(char *idade[100],char *sexo[100],char *causa[100],char *cor[100],char *classe[100])
{
    int x;
    printf("Entre com a idade: ");
    scanf("%d",&x);
    while(x<0)
    {
        system("cls");
        printf("Entre com a idade: ");
        scanf("%d",&x);
    }
    if(x>= 0 && x<=14)
        strcpy(idade,"Infantil");
    if (x>=14 && x<=29)
        strcpy(idade,"Jovem");
    if(x>=30 && x<=64)
        strcpy(idade,"Meia Idade");
    if(x>=65)
        strcpy(idade,"Terceira Idade");
    system("cls");

    printf("1- Masculino;");
    printf("\n2- Feminino;");
    printf("\nEntre com o sexo: ");
    scanf("%d",&x);
    while(x!=1&&x!=2)
    {
        system("cls");
        printf("1- Masculino;");
        printf("\n2- Feminino;");
        printf("\nEntre com o sexo: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(sexo,"Masculino");
    else if (x==2)
        strcpy(sexo,"Feminino");
    system("cls");

    printf("1- Natural;");
    printf("\n2- Nao Natural;");
    printf("\nEntre com a causa da morte: ");
    scanf("%d",&x);
    while(x!=1&&x!=2)
    {
        system("cls");
        printf("1- Natural;");
        printf("\n2- Nao Natural;");
        printf("\nEntre com a causa da morte: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(causa,"Natural");
    else if (x==2)
        strcpy(causa,"Nao Natural");
    system("cls");

    printf("1- Branca;");
    printf("\n2- Amarela;");
    printf("\n3- Negra;");
    printf("\nEntre com a cor da pele: ");
    scanf("%d",&x);
    while(x!=1&&x!=2&&x!=3)
    {
        system("cls");
        printf("1- Branca;");
        printf("\n2- Amarela;");
        printf("\n3- Negra;");
        printf("\nEntre com a cor da pele: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(cor,"Branca");
    else if (x==2)
        strcpy(cor,"Amarela");
    else if (x==3)
        strcpy(cor,"Negra");
    system("cls");

    printf("1- Baixa;");
    printf("\n2- Media;");
    printf("\n3- Alta;");
    printf("\nEntre com a classe social:");
    scanf("%d",&x);
    while(x!=1&&x!=2&&x!=3)
    {
        system("cls");
        printf("1- Baixa;");
        printf("\n2- Media;");
        printf("\n3- Alta;");
        printf("\n Entre com a classe social:");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(classe,"Classe Baixa");
    else if (x==2)
        strcpy(classe,"Classe Media");
    else if (x==3)
        strcpy(classe,"Classe Alta");

    system("cls");
}

void registrar_pt2(nodptr *lista, char idade[100],char sexo[100],char causa[100],char cor[100],char classe[100])
{
    int x;

    int y=0;

    nodptr p = *lista;
    nodptr d;

    d = p->dir;

    while(y == 0)
    {
        if(strcmp((p->idade),idade)==0)
        {
            x = p->qtd;
            x++;
            p->qtd = x;
            if(strcmp(sexo,"Masculino")==0)
            {
                x = p->masc;
                x++;
                p->masc = x;

                if(strcmp(causa,"Natural")==0)
                {
                    x = p->masc_nat;
                    x++;
                    p->masc_nat = x;
                }
                if(strcmp(causa,"Nao Natural")==0)
                {
                    x = p->masc_nonat;
                    x++;
                    p->masc_nonat = x;
                }

                if(strcmp(cor,"Branca")==0)
                {
                    x = p->masc_br;
                    x++;
                    p->masc_br = x;
                }
                if(strcmp(cor,"Amarela")==0)
                {
                    x = p->masc_am;
                    x++;
                    p->masc_am = x;
                }
                if(strcmp(cor,"Negra")==0)
                {
                    x = p->masc_ng;
                    x++;
                    p->masc_ng = x;
                }

                if(strcmp(classe,"Classe Baixa")==0)
                {
                    x = p->masc_bx;
                    x++;
                    p->masc_bx = x;
                }
                if(strcmp(classe,"Classe Media")==0)
                {
                    x = p->masc_md;
                    x++;
                    p->masc_md = x;
                }
                if(strcmp(classe,"Classe Alta")==0)
                {
                    x = p->masc_at;
                    x++;
                    p->masc_at = x;
                }
                y = 1;
            }
            else if(strcmp(sexo,"Feminino")==0)
            {
                x = p->fem;
                x++;
                p->fem = x;

                if(strcmp(causa,"Natural")==0)
                {
                    x = p->fem_nat;
                    x++;
                    p->fem_nat = x;
                }
                if(strcmp(causa,"Nao Natural")==0)
                {
                    x = p->fem_nonat;
                    x++;
                    p->fem_nonat = x;
                }

                if(strcmp(cor,"Branca")==0)
                {
                    x = p->fem_br;
                    x++;
                    p->fem_br = x;
                }
                if(strcmp(cor,"Amarela")==0)
                {
                    x = p->fem_am;
                    x++;
                    p->fem_am = x;
                }
                if(strcmp(cor,"Negra")==0)
                {
                    x = p->fem_ng;
                    x++;
                    p->fem_ng = x;
                }

                if(strcmp(classe,"Classe Baixa")==0)
                {
                    x = p->fem_bx;
                    x++;
                    p->fem_bx = x;
                }
                if(strcmp(classe,"Classe Media")==0)
                {
                    x = p->fem_md;
                    x++;
                    p->fem_md = x;
                }if(strcmp(classe,"Classe Alta")==0)
                {
                    x = p->fem_at;
                    x++;
                    p->fem_at = x;
                }
                y = 1;
            }
            (*lista)= p;
        }
        else if(strcmp((p->idade),idade)!=0)
        {
            p = d;
            d = p->dir;
        }
    }
}

void registrar(nodptr *lista)
{
    int x,i;
    char idade[100],sexo[100],causa[100],cor[100],classe[100],con[100];

    strcpy(con,"S");
    while(strcmp(con,"S")==0)
    {   system("cls");
        registrar_pt1(&idade, &sexo, &causa, &cor, &classe);
        printf("Idade:            %s\n",idade);
        printf("Sexo:             %s\n",sexo);
        printf("Causa da morte:   %s\n",causa);
        printf("Cor:              %s\n",cor);
        printf("Classe social:    %s\n",classe);
        printf("\nDeseja registrar quantas mortes deste tipo?");
        scanf("%d",&x);
        for(i=0;i<x;i++)
        {
            registrar_pt2(&(*lista), idade, sexo, causa, cor, classe);
        }
        system("cls");
        printf("S - Sim;\n");
        printf("N - Nao;\n");
        printf("Deseja registrar mais uma mortalidade?");
        scanf("%s",con);
        system("cls");
        while(strcmp(con,"S")!=0&&strcmp(con,"N")!=0)
        {
            printf("S - Sim;\n");
            printf("N - Nao;\n");
            printf("Deseja registrar mais uma morte?");
            scanf("%s",con);
            system("cls");
        }
    }
    write_2(*lista);
    system("cls");
    puts("Registro feito com sucesso!");
    system("pause");
}


void removed_pt1(int *x, char *idade[100],char *sexo[100],char *causa[100],char *cor[100],char *classe[100])
{
    printf("Entre com a idade: ");
    scanf("%d",&x);
    while(x<0)
    {
        system("cls");
        printf("Entre com a idade: ");
        scanf("%d",&x);
    }
    if(x>= 0 && x<=14)
        strcpy(idade,"Infantil");
    if (x>=14 && x<=29)
        strcpy(idade,"Jovem");
    if(x>=30 && x<=64)
        strcpy(idade,"Meia Idade");
    if(x>=65)
        strcpy(idade,"Terceira Idade");
    system("cls");

    printf("1- Masculino;");
    printf("\n2- Feminino;");
    printf("\nEntre com o sexo: ");
    scanf("%d",&x);
    while(x!=1&&x!=2)
    {
        system("cls");
        printf("1- Masculino;");
        printf("\n2- Feminino;");
        printf("\nEntre com o sexo: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(sexo,"Masculino");
    else if (x==2)
        strcpy(sexo,"Feminino");
    system("cls");

    printf("1- Natural;");
    printf("\n2- Nao Natural;");
    printf("\nEntre com a causa da morte: ");
    scanf("%d",&x);
    while(x!=1&&x!=2)
    {
        system("cls");
        printf("1- Natural;");
        printf("\n2- Nao Natural;");
        printf("\nEntre com a causa da morte: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(causa,"Natural");
    else if (x==2)
        strcpy(causa,"Nao Natural");
    system("cls");

    printf("1- Branca;");
    printf("\n2- Amarela;");
    printf("\n3- Negra;");
    printf("\nEntre com a cor da pele: ");
    scanf("%d",&x);
    while(x!=1&&x!=2&&x!=3)
    {
        system("cls");
        printf("1- Branca;");
        printf("\n2- Amarela;");
        printf("\n3- Negra;");
        printf("\nEntre com a cor da pele: ");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(cor,"Branca");
    else if (x==2)
        strcpy(cor,"Amarela");
    else if (x==3)
        strcpy(cor,"Negra");
    system("cls");

    printf("1- Baixa;");
    printf("\n2- Media;");
    printf("\n3- Alta;");
    printf("\nEntre com a classe social:");
    scanf("%d",&x);
    while(x!=1&&x!=2&&x!=3)
    {
        system("cls");
        printf("1- Baixa;");
        printf("\n2- Media;");
        printf("\n3- Alta;");
        printf("\n Entre com a classe social:");
        scanf("%d",&x);
    }
    if(x==1)
        strcpy(classe,"Classe Baixa");
    else if (x==2)
        strcpy(classe,"Classe Media");
    else if (x==3)
        strcpy(classe,"Classe Alta");
    system("cls");
}

void removed_pt2(nodptr *lista, char idade[100],char sexo[100],char causa[100],char cor[100],char classe[100])
{
    int x;

    int y=0;

    nodptr p = *lista;
    nodptr d;

    d = p->dir;

    while(y == 0)
    {
        if(strcmp((p->idade),idade)==0)
        {
            x = p->qtd;
            if(x>0)
                x--;
            p->qtd = x;
            if(strcmp(sexo,"Masculino")==0)
            {
                x = p->masc;
                if(x>0)
                    x--;
                p->masc = x;

                if(strcmp(causa,"Natural")==0)
                {
                    x = p->masc_nat;
                    if(x>0)
                        x--;
                    p->masc_nat = x;
                }
                if(strcmp(causa,"Nao Natural")==0)
                {
                    x = p->masc_nonat;
                    if(x>0)
                        x--;
                    p->masc_nonat = x;
                }

                if(strcmp(cor,"Branca")==0)
                {
                    x = p->masc_br;
                    if(x>0)
                        x--;
                    p->masc_br = x;
                }
                if(strcmp(cor,"Amarela")==0)
                {
                    x = p->masc_am;
                    if(x>0)
                        x--;
                    p->masc_am = x;
                }
                if(strcmp(cor,"Negra")==0)
                {
                    x = p->masc_ng;
                    if(x>0)
                        x--;
                    p->masc_ng = x;
                }

                if(strcmp(classe,"Classe Baixa")==0)
                {
                    x = p->masc_bx;
                    if(x>0)
                        x--;
                    p->masc_bx = x;
                }
                if(strcmp(classe,"Classe Media")==0)
                {
                    x = p->masc_md;
                    if(x>0)
                        x--;
                    p->masc_md = x;
                }
                if(strcmp(classe,"Classe Alta")==0)
                {
                    x = p->masc_at;
                    if(x>0)
                        x--;
                    p->masc_at = x;
                }
                y = 1;
            }
            else if(strcmp(sexo,"Feminino")==0)
            {
                x = p->fem;
                if(x>0)
                    x--;
                p->fem = x;

                if(strcmp(causa,"Natural")==0)
                {
                    x = p->fem_nat;
                    if(x>0)
                        x--;
                    p->fem_nat = x;
                }
                if(strcmp(causa,"Nao Natural")==0)
                {
                    x = p->fem_nonat;
                    if(x>0)
                        x--;
                    p->fem_nonat = x;
                }

                if(strcmp(cor,"Branca")==0)
                {
                    x = p->fem_br;
                    if(x>0)
                        x--;
                    p->fem_br = x;
                }
                if(strcmp(cor,"Amarela")==0)
                {
                    x = p->fem_am;
                    if(x>0)
                        x--;
                    p->fem_am = x;
                }
                if(strcmp(cor,"Negra")==0)
                {
                    x = p->fem_ng;
                    if(x>0)
                        x--;
                    p->fem_ng = x;
                }

                if(strcmp(classe,"Classe Baixa")==0)
                {
                    x = p->fem_bx;
                    if(x>0)
                        x--;
                    p->fem_bx = x;
                }
                if(strcmp(classe,"Classe Media")==0)
                {
                    x = p->fem_md;
                    if(x>0)
                        x--;
                    p->fem_md = x;
                }
                if(strcmp(classe,"Classe Alta")==0)
                {
                    x = p->fem_at;
                    if(x>0)
                        x--;
                    p->fem_at = x;
                }
                y = 1;
            }
            (*lista)= p;
        }
        else if(strcmp((p->idade),idade)!=0)
        {
            p = d;
            d = p->dir;
        }
    }
}

void removed(nodptr *lista)
{
    int x,i;
    char idade[100],sexo[100],causa[100],cor[100],classe[100],con[100];

    strcpy(con,"S");
    while(strcmp(con,"S")==0)
    {
        system("cls");
        removed_pt1(&x, &idade, &sexo, &causa, &cor, &classe);
        printf("Idade:            %s\n",idade);
        printf("Sexo:             %s\n",sexo);
        printf("Causa da morte:   %s\n",causa);
        printf("Cor:              %s\n",cor);
        printf("Classe social:    %s\n",classe);
        printf("\nDeseja remover quantas mortes deste tipo?");
        scanf("%d",&x);
        for(i=0; i<x; i++)
        {
            removed_pt2(&(*lista), idade, sexo, causa, cor, classe);
        }
        system("cls");
        printf("S - Sim;\n");
        printf("N - Nao;\n");
        printf("Deseja remover mais uma mortalidade?");
        scanf("%s",con);
        system("cls");
        while(strcmp(con,"S")!=0&&strcmp(con,"N")!=0)
        {
            printf("S - Sim;\n");
            printf("N - Nao;\n");
            printf("Deseja remover mais uma morte?");
            scanf("%s",con);
            system("cls");
        }
    }
    write_2(*lista);
    system("cls");
    puts("Remocao feita com sucesso!");
    system("pause");
}


int binaria(struct palavra lista3[], char x[100], int tam)
{
    int achou;
    int meio,baixo,alto,cont;


    baixo = 0;
    alto = tam-1;
    achou = 0;


    while((baixo<=alto)&&(achou==0))
    {
        meio = (int)round((baixo + alto)/2.0);
        if (strcmp(x,lista3[meio].idade)==-1)
            alto = meio - 1;
        else
            if (strcmp(x,lista3[meio].idade)==1)
                baixo = meio + 1;
            else
            {
                achou = 1;
                if(strcmp(x,lista3[meio].idade)==0)
                    cont = meio;
                if(strcmp(x,lista3[alto].idade)==0)
                    cont = alto;
                if(strcmp(x,lista3[baixo].idade)==0)
                    cont = baixo;
            }
    }

    return cont;
}

void busca(nodptr *p, char id[100])
{
    struct palavra *lista3;

    int i,n;

    nodptr q = *p;
    nodptr d = q->dir;

    lista3 = (struct palavra*)malloc(4*sizeof(struct palavra));

    for(i=0; i<4; i++)
    {
        strcpy(lista3[i].idade,q->idade);
        q = d;
        d = q->dir;
    }

    n = binaria(lista3,id,4);

    q = *p;
    for(i=0; i<n; i++)
    {
        d = q->dir;
        q = d;
    }

    (*p) = q;
}


void indice_geral(nodptr lista)
{
    system("cls");

    int x,i;

    float porcent=0,total=0;

    nodptr p = lista;
    nodptr d;

    for(i=0;i<4;i++)
    {
        d = p->dir;
        x = p->qtd;
        total += x;
        p = d;
    }

    p = lista;
    busca(&p,"Infantil");
    if(total!=0)
            porcent = ((p->qtd)/total)*100;
    printf("Mortalidade Infantil: %.2f",porcent);
    puts("%");

    p = lista;
    busca(&p,"Jovem");
    if(total!=0)
            porcent = ((p->qtd)/total)*100;
    printf("Mortalidade Jovem: %.2f",porcent);
    puts("%");

    p = lista;
    busca(&p,"Meia Idade");
    if(total!=0)
            porcent = ((p->qtd)/total)*100;
    printf("Mortalidade Meia Idade: %.2f",porcent);
    puts("%");

    p = lista;
    busca(&p,"Terceira Idade");
    if(total!=0)
            porcent = ((p->qtd)/total)*100;
    printf("Mortalidade Terceira Idade: %.2f",porcent);
    puts("%");

    system("pause");
}

void indice_especifico(nodptr lista)
{
    int i,x,w,z;
    char y[100], idade[100],sexo[100],tipo[100];
    float total=0, porcent=0, porcent2=0,porcent3=0;

    strcpy(idade,"nada");
    strcpy(sexo,"nada");
    strcpy(tipo,"nada");

    nodptr q ;
    nodptr p = lista;
    nodptr d;
    nodptr f;

    for(i=0;i<4;i++)
    {
        d = p->dir;
        x = p->qtd;
        total += x;
        p = d;
    }
    x=0;
    w=0;
    z=0;

    strcpy(y,"6");
    while(strcmp(y,"s")!=0&&strcmp(y,"n")!=0)
    {
        system("cls");
        puts("Deseja pesquisar por:");
        puts("s - Sim");
        puts("n - Nao");
        printf("Idade? ");
        scanf("%s",y);
    }
    if(strcmp(y,"s")==0)
    {
        strcpy(y,"6");
        while(strcmp(y,"1")!=0&&strcmp(y,"2")!=0&&strcmp(y,"3")!=0&&strcmp(y,"4")!=0)
        {
            system("cls");
            puts("1 - Infantil;");
            puts("2 - Jovem;");
            puts("3 - Meia Idade;");
            puts("4 - Terceira Idade;");
            printf("Qual idade deseja pesquisar?");
            scanf("%s",y);
        }

            if(strcmp(y,"1")==0)
                strcpy(idade,"Infantil");
            if(strcmp(y,"2")==0)
                strcpy(idade,"Jovem");
            if(strcmp(y,"3")==0)
                strcpy(idade,"Meia Idade");
            if(strcmp(y,"4")==0)
                strcpy(idade,"Terceira Idade");
    }

    strcpy(y,"5");
    while(strcmp(y,"s")!=0&&strcmp(y,"n")!=0)
    {
        system("cls");
        puts("Deseja pesquisar por:");
        puts("s - Sim");
        puts("n - Nao");
        printf("Sexo?");
        scanf("%s",y);
    }
    if(strcmp(y,"s")==0)
    {
        strcpy(y,"6");
        while(strcmp(y,"1")!=0&&strcmp(y,"2")!=0)
        {
            system("cls");
            puts("1 - Masculino;");
            puts("2 - Feminino;");
            printf("Qual sexo deseja pesquisar? ");
            scanf("%s",y);
        }

            if(strcmp(y,"1")==0)
                strcpy(sexo,"Masculino");
            if(strcmp(y,"2")==0)
                strcpy(sexo,"Feminino");
    }

    strcpy(y,"6");
    while(strcmp(y,"s")!=0&&strcmp(y,"n")!=0)
    {
        system("cls");
        puts("Deseja pesquisar por:");
        puts("s - Sim");
        puts("n - Nao");
        printf("Causa da morte, Cor da Pele ou Classe Social?");
        scanf("%s",y);
    }
    if(strcmp(y,"s")==0)
    {
        strcpy(y,"6");
        while(strcmp(y,"1")!=0&&strcmp(y,"2")!=0&&strcmp(y,"3")!=0&&strcmp(y,"4")!=0)
        {
            system("cls");
            puts("1 - Causa da Morte;");
            puts("2 - Cor da Pele;");
            puts("3 - Classe Social;");
            printf("Por qual caracteristica deseja pesquisar? ");
            scanf("%s",y);
        }

            if(strcmp(y,"1")==0)
                strcpy(tipo,"Causa da Morte");
            if(strcmp(y,"2")==0)
                strcpy(tipo,"Cor da Pele");
            if(strcmp(y,"3")==0)
                strcpy(tipo,"Classe Social");
    }

    if(strcmp(idade,"nada")!=0)
    {
        p = lista;
        q = p->esq;
        d = p->dir;
        f = q->esq;

        if(strcmp(idade,(d->idade))==0)
            p = d;
        else if(strcmp(idade,(q->idade))==0)
            p = q;
        else if(strcmp(idade,(f->idade))==0)
            p = f;

        if(strcmp(sexo,"nada")!=0)
        {
            if(strcmp(tipo,"nada")!=0)
            {
                if(strcmp(tipo,"Causa da Morte")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        x = p->masc_nat;
                        w = p->masc_nonat;
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        x = p->fem_nat;
                        w = p->fem_nonat;
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade da idade %s do sexo %s pela %s:\n\n",idade,sexo,tipo);
                    printf("           - Causa Natural:     %.2f",porcent);
                    puts("%");
                    printf("           - Causa Nao Natural: %.2f",porcent2);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Cor da Pele")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        x = p->masc_br;
                        w = p->masc_am;
                        z = p->masc_ng;
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        x = p->fem_br;
                        w = p->fem_am;
                        z = p->fem_ng;
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade da idade %s do sexo %s pela %s:\n\n",idade,sexo,tipo);
                    printf("           - Cor Branca:  %.2f",porcent);
                    puts("%");
                    printf("           - Cor Amarela: %.2f",porcent2);
                    puts("%");
                    printf("           - Cor Negra:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Classe Social")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        x = p->masc_bx;
                        w = p->masc_md;
                        z = p->masc_at;
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        x = p->fem_bx;
                        w = p->fem_md;
                        z = p->fem_at;
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade da idade %s do sexo %s pela %s:\n\n",idade,sexo,tipo);
                    printf("           - Classe Baixa:  %.2f",porcent);
                    puts("%");
                    printf("           - Classe Media:  %.2f",porcent2);
                    puts("%");
                    printf("           - Classe Alta:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
            }
            else if(strcmp(tipo,"nada")==0)
            {
                if(strcmp(sexo,"Masculino")==0)
                    x = p->masc;
                if(strcmp(sexo,"Feminino")==0)
                    x = p->fem_nat;

                porcent = (x/total)*100;
                system("cls");
                printf("A porcentagem da mortalidade da idade %s do sexo %s: %.2f",idade,sexo,porcent);
                puts("%");
                puts("");
            }
        }
        else if(strcmp(sexo,"nada")==0)
        {
            x = p->qtd;
            porcent = (x/total)*100;
            system("cls");
            printf("A porcentagem da mortalidade da idade %s: %.2f",idade,porcent);
            puts("%");
            puts("");
        }
    }
    else if(strcmp(idade,"nada")==0)
    {
        if(strcmp(sexo,"nada")!=0)
        {
            if(strcmp(tipo,"nada")!=0)
            {
                if(strcmp(tipo,"Causa da Morte")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->masc_nat) + (d->masc_nat) + (q->masc_nat) + (f->masc_nat);
                        w = (p->masc_nonat) + (d->masc_nonat) + (q->masc_nonat) + (f->masc_nonat);
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->fem_nat) + (d->fem_nat) + (q->fem_nat) + (f->fem_nat);
                        w = (p->fem_nonat) + (d->fem_nonat) + (q->fem_nonat) + (f->fem_nonat);
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade do sexo %s pela %s:\n\n",sexo,tipo);
                    printf("           - Causa Natural:     %.2f",porcent);
                    puts("%");
                    printf("           - Causa Nao Natural: %.2f",porcent2);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Cor da Pele")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->masc_br) + (d->masc_br) + (q->masc_br) + (f->masc_br);
                        w = (p->masc_am) + (d->masc_am) + (q->masc_am) + (f->masc_am);
                        z = (p->masc_ng) + (d->masc_ng) + (q->masc_ng) + (f->masc_ng);
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->fem_br) + (d->fem_br) + (q->fem_br) + (f->fem_br);
                        w = (p->fem_am) + (d->fem_am) + (q->fem_am) + (f->fem_am);
                        z = (p->fem_ng) + (d->fem_ng) + (q->fem_ng) + (f->fem_ng);
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade do sexo %s pela %s:\n\n",sexo,tipo);
                    printf("           - Cor Branca:  %.2f",porcent);
                    puts("%");
                    printf("           - Cor Amarela: %.2f",porcent2);
                    puts("%");
                    printf("           - Cor Negra:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Classe Social")==0)
                {
                    if(strcmp(sexo,"Masculino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->masc_bx) + (d->masc_bx) + (q->masc_bx) + (f->masc_bx);
                        w = (p->masc_md) + (d->masc_md) + (q->masc_md) + (f->masc_md);
                        z = (p->masc_at) + (d->masc_at) + (q->masc_at) + (f->masc_at);
                    }
                    if(strcmp(sexo,"Feminino")==0)
                    {
                        p = lista;
                        d = p->dir;
                        q = p->esq;
                        f = q->esq;
                        x = (p->fem_bx) + (d->fem_bx) + (q->fem_bx) + (f->fem_bx);
                        w = (p->fem_md) + (d->fem_md) + (q->fem_md) + (f->fem_md);
                        z = (p->fem_at) + (d->fem_at) + (q->fem_at) + (f->fem_at);
                    }

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade do sexo %s pela %s:\n\n",sexo,tipo);
                    printf("           - Classe Baixa:  %.2f",porcent);
                    puts("%");
                    printf("           - Classe Media:  %.2f",porcent2);
                    puts("%");
                    printf("           - Classe Alta:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
            }
            else if(strcmp(tipo,"nada")==0)
            {
                if(strcmp(sexo,"Masculino")==0)
                {
                    p = lista;
                    d = p->dir;
                    q = p->esq;
                    f = q->esq;
                    x = (p->masc) + (d->masc) + (q->masc) + (f->masc);
                }
                if(strcmp(sexo,"Feminino")==0)
                {
                    p = lista;
                    d = p->dir;
                    q = p->esq;
                    f = q->esq;
                    x = (p->fem) + (d->fem) + (q->fem) + (f->fem);
                }

                porcent = (x/total)*100;
                system("cls");
                printf("A porcentagem da mortalidade do sexo %s: %.2f",sexo,porcent);
                puts("%");
                puts("");
            }
        }
        else if(strcmp(sexo,"nada")==0)
        {
            if(strcmp(tipo,"nada")!=0)
            {
                if(strcmp(tipo,"Causa da Morte")==0)
                {
                    p = lista;
                    d = p->dir;
                    q = p->esq;
                    f = q->esq;
                    x = (p->masc_nat) + (d->masc_nat) + (q->masc_nat) + (f->masc_nat) + (p->fem_nat) + (d->fem_nat) + (q->fem_nat) + (f->fem_nat);
                    w = (p->masc_nonat) + (d->masc_nonat) + (q->masc_nonat) + (f->masc_nonat) + (p->fem_nonat) + (d->fem_nonat) + (q->fem_nonat) + (f->fem_nonat);

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade pela %s:\n\n",tipo);
                    printf("           - Causa Natural:     %.2f",porcent);
                    puts("%");
                    printf("           - Causa Nao Natural: %.2f",porcent2);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Cor da Pele")==0)
                {
                    p = lista;
                    d = p->dir;
                    q = p->esq;
                    f = q->esq;
                    x = (p->masc_br) + (d->masc_br) + (q->masc_br) + (f->masc_br) + (p->fem_br) + (d->fem_br) + (q->fem_br) + (f->fem_br);
                    w = (p->masc_am) + (d->masc_am) + (q->masc_am) + (f->masc_am) + (p->fem_am) + (d->fem_am) + (q->fem_am) + (f->fem_am);
                    z = (p->masc_ng) + (d->masc_ng) + (q->masc_ng) + (f->masc_ng) + (p->fem_ng) + (d->fem_ng) + (q->fem_ng) + (f->fem_ng);

                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade pela %s:\n\n",tipo);
                    printf("           - Cor Branca:  %.2f",porcent);
                    puts("%");
                    printf("           - Cor Amarela: %.2f",porcent2);
                    puts("%");
                    printf("           - Cor Negra:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
                else if(strcmp(tipo,"Classe Social")==0)
                {
                    p = lista;
                    d = p->dir;
                    q = p->esq;
                    f = q->esq;
                    x = (p->masc_bx) + (d->masc_bx) + (q->masc_bx) + (f->masc_bx) + (p->fem_bx) + (d->fem_bx) + (q->fem_bx) + (f->fem_bx);
                    w = (p->masc_md) + (d->masc_md) + (q->masc_md) + (f->masc_md) + (p->fem_md) + (d->fem_md) + (q->fem_md) + (f->fem_md);
                    z = (p->masc_at) + (d->masc_at) + (q->masc_at) + (f->masc_at) + (p->fem_at) + (d->fem_at) + (q->fem_at) + (f->fem_at);


                    porcent = (x/total)*100;
                    porcent2 = (w/total)*100;
                    porcent3 = (z/total)*100;
                    system("cls");
                    printf("A porcentagem da mortalidade pela %s:\n\n",tipo);
                    printf("           - Classe Baixa:  %.2f",porcent);
                    puts("%");
                    printf("           - Classe Media:  %.2f",porcent2);
                    puts("%");
                    printf("           - Classe Alta:   %.2f",porcent3);
                    puts("%");
                    puts("");
                }
            }
            else if(strcmp(tipo,"nada")==0)
            {
                system("cls");
                printf("Entrou com nenhum dado para a pesquisa!\n\n");
            }
        }
    }



    system("pause");
}

void indice(lista)
{
    system("cls");

    char x[100];
    do
    {
        printf("1- Indice Geral; \n");
        printf("2- Indice especifico; \n\n");
        printf("O que deseja consultar?");
        scanf("%s",&x);
    }while(strcmp(x,"1")!=0 && strcmp(x,"2"));

    if(strcmp(x,"1")==0)
        indice_geral(lista);
    else if(strcmp(x,"2")==0)
        indice_especifico(lista);
}


void site()
{
    char link[] = "start chrome ftp.ibge.gov.br/Tabuas_Completas_de_Mortalidade/Tabuas_Completas_de_Mortalidade_2015/tabua_de_mortalidade_analise.pdf";

	system(link);

}


int main()
{
    system("color F1");

    nodptr lista = NULL;

    criad(&lista);
    write(&lista);

    char enter[100];

    do{
        system("cls");
        puts("------------------------------------------------------------------------------------------------------------------------");
        puts("############################################ BEM-VINDO AO MORTALIZER ###################################################");
        puts("------------------------------------------------------------------------------------------------------------------------");
        printf("\n");
        puts("Digite:\n ");
        puts("       0- Sair;");
        puts("       1- Registrar;");
        puts("       2- Excluir;");
        puts("       3- Consultar o indice de mortalidade;");
        puts("       4- Reiniciar indices;");
        puts("       5- Abrir o site com o a tabela completa de mortalidade de 2015 (IBGE);");
        printf("\nO que deseja fazer? ");
        scanf("%s",enter);

        if(strcmp(enter,"1")==0)
        {
            registrar(&lista);
            alfabetic(&lista);
        }
        if(strcmp(enter,"2")==0)
        {
            removed(&lista);
            alfabetic(&lista);
        }
        if(strcmp(enter,"3")==0)
            indice(lista);
        if(strcmp(enter,"4")==0)
        {
            remove("mortalizer2.txt");
            criad(&lista);
            write(&lista);
        }
        if(strcmp(enter,"5")==0)
            site();
    }
    while(strcmp(enter,"0")!=0);

    return 0;
}
