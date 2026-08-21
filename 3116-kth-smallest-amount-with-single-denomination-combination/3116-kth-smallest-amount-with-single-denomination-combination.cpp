#include <vector>
#include <numeric>
#include <algorithm>

class Solution {
public:
    long long findKthSmallest(std::vector<int>& coins, int k) {
        long long low = 1;
        long long high = 1LL * *std::min_element(coins.begin(), coins.end()) * k;
        long long ans = high;
        int n = coins.size();

        std::vector<std::pair<long long, int>> subsets;
        
        for (int mask = 1; mask < (1 << n); ++mask) {
            long long current_lcm = 1;
            int bits = 0;
            bool overflow = false;
            
            for (int i = 0; i < n; ++i) {
                if ((mask >> i) & 1) {
                    bits++;
                    long long g = std::gcd(current_lcm, (long long)coins[i]);
                    if (current_lcm > (high * g) / coins[i]) {
                        overflow = true;
                        break;
                    }
                    current_lcm = (current_lcm / g) * coins[i];
                }
            }
            
            if (!overflow) {
                int sign = (bits % 2 == 1) ? 1 : -1;
                subsets.push_back({current_lcm, sign});
            }
        }

        while (low <= high) {
            long long mid = low + (high - low) / 2;
            long long count = 0;

            for (const auto& subset : subsets) {
                count += (mid / subset.first) * subset.second;
            }

            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
};
