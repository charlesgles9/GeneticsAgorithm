# GeneticsAgorithm

## Implementation

### Steps
1. **Initialize-** create a population at random with random genes.
2. **Selection-**  create fitness function for each element in the population.
3. **Gene Pool-**  create a gene pool that will be used to create changes in the population.
4. **Reproduction:**
    - calculate fitness.
    - sort the population using the fitness as the weights.
    - pick two random parents in the population.
      1. crossover-> create a new child by combining the two parents genes.
      2. mutation-> apply mutations to the new child.
      3. add this child to a new population
    - finally replace the old population with new population. *Move to step 2 until phrase is found.*
    
    
  ## Things to note:
  1. The fitness function is the heart of this algorithm. 
  2. The mutation function must have a random rate. why? because if the mutations happen rapidly then it will suddenly become a brute force method
     rather than an adaptive heuristic function. Play around with the mutation rate and find a goldilock zone(optimum weight).
    
  ## Output 
  
  
![crop2](https://user-images.githubusercontent.com/41951671/180601013-ceb80df5-2c5e-4a8a-afe0-becd6ba3ab89.png)

![crop2](https://user-images.githubusercontent.com/41951671/180601208-292c9d3e-f490-4faf-bf6f-6a019d4fb471.png)

![Selection_002](https://user-images.githubusercontent.com/41951671/180600795-377a99a2-3caa-4ee1-9669-30f7b34bd458.png)
