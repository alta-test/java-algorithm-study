def solution(nums):
    max_pos = len(nums)//2
    # 연구실에 있는 폰켓몬의 종류가 가져갈수 있는 수보다 작다면, 
    if len(set(nums)) < max_pos:
        return len(set(nums))
    # 연구실에 있는 폰켓몬의 종류가 가져갈 수 있는 수보다 많다면, 어차피 n//2 마리만 가져갈 수 있으므로
    else:
        return max_pos