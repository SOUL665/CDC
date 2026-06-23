// Answer - 1

#include<bits/stdc++.h>
using namespace std;

int main(){
    char h,l,g;
    int a;
    cin>>h;
    cin>>l;
    cin>>g;
    cin>>a;

    if(h=='e' && l=='c' && g=='m' && 25<=a && a<=35){
        cout<<"The Premium Is Rs.4 Per Thousand And His Policy Cannot Exceed Rs.2 Lakhs"<<endl; 
    }
    else if(h=='e' && l=='c' && g=='f' && 25<=a && a<=35){
        cout<<"The Premium Is Rs.3 Per Thousand And Her Policy Cannot Exceed Rs.1 Lakhs"<<endl;
    }
    else if(h=='p' && l=='v' && g=='m' && 25<=a && a<=35){
        cout<<"The Premium Is Rs.6 Per Thousand And Cannot Exceed Rs.10,000"<<endl;
    }
    else
    {
        cout<<"Not Insured"<<endl;
    }
    return 0;
}


// Answer - 2 

#include<stdio.h>

int main(){
    int a,b;
    scanf("%d",&a);
    scanf("%d",&b);
    if(a>0 && b>0){
        printf("Ist Quadrant\n");
    }
    else if(a<0 && b>0){
        printf("IInd Quadrant\n");
    }
    else if(a<0 && b<0){
        printf("IIIrd Quadrant\n");
    }
    else if(a>0 && b<0){
        printf("IVth Quadrant\n");
    }
    else {
        printf("origin\n");
    }
    return 0;
}
