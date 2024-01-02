//#include <vector>
//#include <map>
//#include "../Pixel.h"
//#include "DominantColour.h"
//#include "libraryInterfaces_DominantColourInterface.h"
//using namespace std;
//
//vector<vector<Pixel>> applyDominantColour(vector < vector<Pixel> > image){
//    //unordered_map <pair<pair<float,float>,float> , int> um;
//    map<pair<pair<int,int>,int> , int> um;
//    for (int i = 0; i < image.size(); ++i) {
//        for (int j = 0; j < image[i].size(); ++j) {
//            pair<int,int> rg = make_pair(image[i][j].r,image[i][j].g);
//            pair<pair<int,int>,int> rgb = make_pair(rg,image[i][j].b);
//            if(um.find(rgb) == um.end()){
//                um[rgb] = 1;
//            }
//            else{
//                um[rgb] = um[rgb] + 1;
//            }
//        }
//    }
//    int max  = 0;
//    pair<pair<int,int> , int> maxcolour;
//    for(auto i : um){
//        if(max < i.second){
//            maxcolour = i.first;
//            max = i.second;
//        }
//    }
//    int r = maxcolour.first.first;
//    int g = maxcolour.first.second;
//    int b = maxcolour.second;
//    for(int i =0;i<image.size();++i){
//        for(int j =0;j<image[i].size();++j){
//            image[i][j].r = r;
//            image[i][j].g = g;
//            image[i][j].b = b;
//        }
//    }
//    return image;
//}