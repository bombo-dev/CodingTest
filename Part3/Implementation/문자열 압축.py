s = "aabbaccc"

max_compression = len(s)//2
answer = len(s)

def compression(s, i):
    new_string = ""
    count = 1
    slice_list = []
    for k in range(0, len(s), i):
        slice_list.append(s[k:k+i])

    for i in range(1, len(slice_list)):
        if slice_list[i - 1] == slice_list[i]:
            count += 1
        elif slice_list[i - 1] != slice_list[i] and count == 1:
            new_string += slice_list[i - 1]
        else:
            new_string += str(count) + slice_list[i - 1]
            count = 1

        if i == len(slice_list) - 1 and count == 1:
            new_string += slice_list[i]
        elif i == len(slice_list) - 1 and count != 1:
            new_string += str(count) + slice_list[i - 1]
    return len(new_string)

for i in range(1, max_compression + 1):
    result = compression(s, i)
    if result < answer:
        answer = result

print(answer)
