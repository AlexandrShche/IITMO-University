; hello.asm
section .data
message: db  'hello, world!', 10

section .text
global _start

exit:
    mov     rax, 60         ;  Это функция
    xor     rdi, rdi           ;  Это функция
    syscall                     ;  Это функция

print_string:
  mov     rax, 1
  mov     rdi, 1
  mov     rsi, message
  mov     rdx, 14
  syscall
  ret

_start:
    call print_string
    call print_string
    call exit                    ; это вызов функции exit
