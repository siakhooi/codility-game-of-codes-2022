# Codility Challenge: Game of Codes

## ThreeLettersBlocks

- Difficulty: Hard
- Given a string S, delete as few letters as possible to obtain a word composed of at most three blocks.
- <https://app.codility.com/programmers/challenges/game_of_codes_2022/>
- <https://app.codility.com/programmers/task/three_letters_blocks/>

## Versions

- Result
  - `Good`: Correctness 100%, Performance 100%.
  - `OK`: Correctness 100%, Performance <100%.
  - `Timeout`: Correctness <100%, Performance <100%, Failed on Timeout.
  - `Fail`: Correctness <100%, Performance <100%.
- File naming convention
  - Code `A`: `GameOfCodes2022A.java`
  - etc

### Gold Award

| File | Complexity | Result | Report                                                                            |
| ---- | ---------- | ------ | --------------------------------------------------------------------------------- |
| `C1` | `O(N)`     | `Good` | [KGHNJG](https://app.codility.com/cert/view/certKGHNJG-Q57ZMPV7MRGARG2V/details/) |

### Timeout

| File | Complexity                                             | Report                                                                            |
| ---- | ------------------------------------------------------ | --------------------------------------------------------------------------------- |
| `A1` | `O(N*2**N)` or `O(N*A**2)` or `O(N*A**3)`              | [ADQTPG](https://app.codility.com/cert/view/certADQTPG-3CB288MW2UHHU3M8/details/) |
| `B`  | `O(N**2)` or `O(N**2*A)` or `O(N*A**2)` or `O(N*A**3)` | [BTQ7M4](https://app.codility.com/cert/view/certBTQ7M4-PRTZTV9H6WQJ7Y3B/details/) |

### Submitted after Challenge Ends

| File | Description                                        | Complexity                                  | Result    | Report                                                              |
| ---- | -------------------------------------------------- | ------------------------------------------- | --------- | ------------------------------------------------------------------- |
| `A2` | Tunning of `A1`, rearrange - delete to last option | `O(N * 2**N) or O(N * A**2) or O(N * A**3)` | `Timeout` | [62W3J2](https://app.codility.com/demo/results/training62W3J2-WS6/) |
| `A3` | Array version of `A1`                              | `O(N**3) or O(N**3 * A)`                    | `Timeout` | [UWTPNC](https://app.codility.com/demo/results/trainingUWTPNC-ZXA/) |
| `C2` | Class version of `C1`                              | `O(N)`                                      | `Good`    | [HP6YWE](https://app.codility.com/demo/results/trainingHP6YWE-QAA/) |

- `A` - recursive logic
- `B` - non recursive logc
