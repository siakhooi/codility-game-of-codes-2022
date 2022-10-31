# Codility Challenge: Game of Codes

## ThreeLettersBlocks

- Difficulty: Hard
- Given a string S, delete as few letters as possible to obtain a word composed of at most three blocks.
- <https://app.codility.com/programmers/challenges/game_of_codes_2022/>
- <task-url>

## Versions

- Result
  - `Good`: Correctness 100%, Performance 100%.
  - `OK`: Correctness 100%, Performance <100%.
  - `Timeout`: Correctness <100%, Performance <100%, Failed on Timeout.
  - `Fail`: Correctness <100%, Performance <100%.
- File naming convention
  - Code `A`: `ChallengeNameA.java`
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

### Unsubmitted

| File | Description                                        |
| ---- | -------------------------------------------------- |
| `A2` | Tunning of `A1`, rearrange - delete to last option |
| `A3` | Array version of `A1`                              |
| `C2` | Class version of `C1`                              |

- `A` - recursive logic
- `B` - non recursive logc
