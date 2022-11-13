import copy


def turn_clock(key):
    previous_key = copy.deepcopy(key)
    for i in range(len(key)):
        for j in range(len(key)):
            key[i][j] = previous_key[len(key) - 1 - j][i]

    return key


def solution(key, lock):
    answer = False  # 시작은 False
    lock_size = (len(lock))  # 자물쇠 사이즈
    key_size = (len(key))  # 열쇠 사이즈
    new_lock_size = (len(lock)) * 3  # 새로운 자물쇠 사이즈를 행렬 3배씩 증가
    new_lock = [[0] * new_lock_size for _ in range(new_lock_size)]  # 3배씩 크기가 증가된 자물쇠

    for i in range(lock_size, lock_size * 2):
        for j in range(lock_size, lock_size * 2):
            new_lock[i][j] = lock[i - lock_size][j - lock_size]  # 자물쇠의 초기 상태 초기화

    for _ in range(4):
        key = turn_clock(key)  # 열쇠 회전
        for x in range(lock_size * 2):  # 새로운 자물쇠의 사이즈 만큼
            for y in range(lock_size * 2):
                check_lock = copy.deepcopy(new_lock)  # 자물쇠를 체크하기 위해 새로 초기화 된 자물쇠 가져오기
                sum = 0
                for i in range(key_size):
                    for j in range(key_size):
                        if new_lock[x + i][y + j] == 0 and key[i][j] == 1:  # 자물쇠가 0이고 key가 1 일때만 변환
                            check_lock[x + i][y + j] = key[i][j]
                        elif new_lock[x + i][y + j] == 1 and key[i][j] == 1:
                            check_lock[x + i][y + j] = 0
                for w in range(lock_size, lock_size * 2):
                    for z in range(lock_size, lock_size * 2):
                        sum += check_lock[w][z]  # 자물쇠에 있는 값이 전부다 1인지 확인
                if sum == lock_size * lock_size:  # 전부다 1로 꽉차있다면 그 값은 자물쇠의 사이즈와 같음
                    answer = True
                    return answer

    return answer