// Answer - 1

#include <iostream>
#include <string>
#include <vector>
using namespace std;

struct Fish{
    string name;
    double price;
    int quantity;
};

class FishMarket{
    private:
    std::vector<Fish> fishes;
    
    public:
    void addFish(string name , double price , int quantity){
        fishes.push_back({name , price , quantity});
        cout<<"Fish"<< name << " added with price Rs." << price << " and quantity " << quantity << endl;
    }
    
    void displayFish(){
        cout << "Available fish:" << endl;
        for (const auto& f : fishes){
            cout << "-" << f.name << " Rs." << f.price << "; Quantity: " << f.quantity << endl;
        }
    }
    
    void updateFishPrice(string name, double newPrice){
        for(auto& f : fishes){
            if (f.name == name){
                f.price = newPrice;
                cout << "Fish " << name << " price updated to Rs." << newPrice << endl;
                return;
            }
        }
        
        cout << "Fish "<< name <<  " not found in the list. Cannot update price." << endl;
    }
    
    void sellFish(string  name , int quantity){
        for (auto& f : fishes){
            if (f.name == name){
                if(f.quantity >= quantity){
                    f.quantity -= quantity;
                    cout << quantity << " units of fish" << name << " sold." << endl;
                }
                else{
                    cout <<"Insufficient quantity." << endl;
                }
                return;
            }
        }
        cout <<"Fish " << name << " not found in the list. Cannot sell." << endl;
    }
};

int main() {
    FishMarket fishMarket;

    int n;
    std::cin >> n;

    for (int i = 0; i < n; i++) {
        std::string name;
        double price;
        int quantity;

        std::cin.ignore();
        std::getline(std::cin, name);

        std::cin >> price;
        std::cin >> quantity;

        fishMarket.addFish(name, price, quantity);
    }

    fishMarket.displayFish();

    std::string fishToUpdate;
    double newPrice;

    std::cin.ignore();
    std::getline(std::cin, fishToUpdate);

    std::cin >> newPrice;

    fishMarket.updateFishPrice(fishToUpdate, newPrice);

    std::string fishToSell;
    int quantityToSell;

    std::cin.ignore();
    std::getline(std::cin, fishToSell);
    std::cin >> quantityToSell;

    fishMarket.sellFish(fishToSell, quantityToSell);
    fishMarket.displayFish();

    return 0;
}

// ======================================================================================================================================== //

// Answer - 2

#include <iostream>
#include <map>
#include <string>
#include <vector>
using namespace std;

#include <algorithm>

void insertCrimeData(int n , map<string, vector<string>>& dC , map<string, map<string , int>> &dCC, map<string , int>&dS){
    while(n--){
        string d, c; int s ; cin >> d >> c >> s;
        dC[d].push_back(c) ; dCC[d][c]++; dS[d] += s;
    }
}

void displayDistrictTotals(map<string, vector<string>>& dC){
    cout << "District totals:\n";
    for(auto const& [d, v] : dC)cout << d << " " << v.size() << "\n";
}

void displayCrimeBreakdown(map <string ,map<string , int >>& dCC , string q){
    cout <<  q << " breakdown:\n";
    for(auto const& [c, count] : dCC[q]) cout << c << " " << count << "\n";
}

void displaySeverity(map<string, int>& dS , string q){
    cout << "Severity:\n" << dS[q] << "\n" ;
}

void displayRankings(map<string , int>& dS){
    cout << "Rankings:\n";
    vector < pair < string, int >> v(dS.begin() , dS.end());
    sort(v.begin() , v.end() , [](auto& a , auto& b){
        return a.second == b.second ? a.first < b.first : a.second > b.second;
    });
    for(auto const& p : v) cout << p.first << " " << p.second << "\n";
}

int main() {
    int reports;
    cin >> reports;
    
    map<string, vector<string>> districtCrimes;
    map<string, map<string, int>> districtCrimeCount;
    map<string, int> districtSeverity;
    
    insertCrimeData(reports, districtCrimes, districtCrimeCount, districtSeverity);
    
    displayDistrictTotals(districtCrimes);
    
    string queryDistrict;
    cin >> queryDistrict;
    
    displayCrimeBreakdown(districtCrimeCount, queryDistrict);
    displaySeverity(districtSeverity, queryDistrict);
    displayRankings(districtSeverity);
    
    return 0;
}
